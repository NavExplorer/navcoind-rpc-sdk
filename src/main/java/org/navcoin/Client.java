package org.navcoin;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import net.sf.ezmorph.bean.MorphDynaBean;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.navcoin.exception.HttpException;
import org.navcoin.exception.NavcoinException;

public class Client {
    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private HttpHost httpHost;
    private HttpClientContext context;

    public Client(String host, int port, String protocol, String username, String password) {
        httpHost = new HttpHost(host, port, protocol);
        initializeAuthentication(username, password);
    }

    <T> T get(Request request, Class<T> object) {
        try {
            return (T) this.sendRequest(request, object);
        } catch (NavcoinException e) {
            throw e;
        } catch (Throwable e) {
            throw new NavcoinException(String.format("Failed to retrieve data for the `%s` request", request.getMethod()), e);
        }
    }


    private Object sendRequest(Request request, Class object) throws Throwable {
        HttpPost httpPost = new HttpPost("/");
        httpPost.setEntity(new ByteArrayEntity(request.toString().getBytes("UTF-8")));

        CloseableHttpResponse httpResponse = httpClient.execute(httpHost, httpPost, this.context);

        Object response;
        try {
            checkHttpErrors(httpResponse);

            String jsonResponse = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
            JSONObject jsonObject = JSONObject.fromObject(jsonResponse);
            MorphDynaBean baseResponse = (MorphDynaBean)JSONObject.toBean(jsonObject);
            checkNavcoinErrors((MorphDynaBean)baseResponse.get("error"));

            if (requiresHydration(object)) {
                response = new ObjectMapper().readValue(JSONSerializer.toJSON(baseResponse.get("result")).toString(), object);
            } else {
                response = baseResponse.get("result");
            }
        } finally {
            httpResponse.close();
        }

        return response;
    }

    private void initializeAuthentication(String username, String password) {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(httpHost.getHostName(), httpHost.getPort()),
                new UsernamePasswordCredentials(username, password)
        );

        AuthCache authCache = new BasicAuthCache();
        authCache.put(httpHost, new BasicScheme());

        context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);
        context.setAuthCache(authCache);
    }

    private void checkHttpErrors(HttpResponse response) throws HttpException {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200 && statusCode != 500) {
            String message;
            try {
                message = IOUtils.toString(response.getEntity().getContent());
            } catch (IOException e) {
                message = e.getMessage();
            }

            throw new HttpException(String.format("Navcoind: %s :: %d", message, statusCode));
        }
    }

    private void checkNavcoinErrors(MorphDynaBean jsonError) throws NavcoinException {
        if (jsonError != null) {
            throw new NavcoinException((String)jsonError.get("message"));
        }
    }

    private boolean requiresHydration(Class object) {
        return !object.getName().equals("java.lang.String");
    }
}

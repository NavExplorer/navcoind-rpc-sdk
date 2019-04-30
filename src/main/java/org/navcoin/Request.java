package org.navcoin;

import java.util.Arrays;

public class Request {
    private Class object;
    private String jsonrpc = "2.0";
    private String method;
    private Object[] params;
    private String id = "navcoin";

    public Request(String method) {
        this.method = method;
    }

    public Request(String method, Object[] params) {
        this.method = method;
        this.params = params;
    }

    public static Request factory(String method) {
        return new Request(method);
    }

    public static Request factory(String method, Object[] params) {
        return new Request(method, params);
    }

    public String toString() {
        return String.format("{\"jsonrpc\": \"%s\", \"method\": \"%s\", \"params\": [%s], \"id\": \"%s\"}", this.jsonrpc, this.method, this.buildParamsString(), this.id);
    }

    private String buildParamsString() {
        StringBuilder params = new StringBuilder();
        if (this.params != null && this.params.length > 0) {
            for(int i = 0; i < this.params.length; ++i) {
                if (i > 0) {
                    params.append(",");
                }

                Object param = this.params[i];
                params.append(String.format(param instanceof String ? "\"%s\"" : "%s", param));
            }
        }

        return params.toString();
    }

    public Class getObject() {
        return this.object;
    }

    public String getJsonrpc() {
        return this.jsonrpc;
    }

    public String getMethod() {
        return this.method;
    }

    public Object[] getParams() {
        return this.params;
    }

    public String getId() {
        return this.id;
    }

    public void setObject(Class object) {
        this.object = object;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public void setId(String id) {
        this.id = id;
    }


}

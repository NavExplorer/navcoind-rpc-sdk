package org.navcoin;

import java.util.ArrayList;
import java.util.List;
import org.navcoin.response.Block;
import org.navcoin.response.CFundStats;
import org.navcoin.response.Info;
import org.navcoin.response.PaymentRequest;
import org.navcoin.response.Proposal;
import org.navcoin.response.Transaction;
import org.navcoin.response.ValidateAddress;

public class NavcoinApi {
    private Client client;

    public NavcoinApi(Client client) {
        this.client = client;
    }

    public Info getInfo() {
        return client.get(Request.factory("getinfo"), Info.class);
    }

    public Transaction getTransaction(String hash) {
        return client.get(Request.factory("getrawtransaction", new Object[]{hash, 1}), Transaction.class);
    }

    public String getRawTransaction(String hash) {
        return client.get(Request.factory("getrawtransaction", new Object[]{hash, 1}), String.class);
    }

    public String getBlockHash(Integer index) {
        return client.get(Request.factory("getblockhash", new Object[]{index}), String.class);
    }

    public String getBestBlockHash() {
        return client.get(Request.factory("getbestblockhash"), String.class);
    }

    public Block getBlock(String hash) {
        return client.get(Request.factory("getblock", new Object[]{hash}), Block.class);
    }

    public String getRawBlock(String hash) {
        return client.get(Request.factory("getblock", new Object[]{hash}), String.class);
    }

    public ValidateAddress validateAddress(String hash) {
        return client.get(Request.factory("validateaddress", new Object[]{hash}), ValidateAddress.class);
    }

    public Proposal getProposal(String hash) {
        return client.get(Request.factory("getproposal", new Object[]{hash}), Proposal.class);
    }

    public PaymentRequest getPaymentRequest(String hash) {
        return client.get(Request.factory("getpaymentrequest", new Object[]{hash}), PaymentRequest.class);
    }

    public CFundStats getCFundStats() {
        return client.get(Request.factory("cfundstats"), CFundStats.class);
    }
}

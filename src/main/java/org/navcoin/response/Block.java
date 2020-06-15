package org.navcoin.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Block {
    private String hash;
    private long confirmations;
    private int strippedsize;
    private long size;
    private int weight;
    private long height;
    private long version;
    private String versionHex;
    private String merkleroot;
    private List<String> tx;
    private int tx_count;
    private int proposal_count;
    private int payment_request_count;
    private int proposal_votes_count;
    private int payment_request_votes_count;
    private int payment_request_payouts_count;
    private long time;
    private int mediantime;
    private long nonce;
    private String bits;
    private Double difficulty;
    private String chainwork;
    private String previousblockhash;
    private String nextblockhash;
}

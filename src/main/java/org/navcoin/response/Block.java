package org.navcoin.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
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
    private long time;
    private int mediantime;
    private long nonce;
    private String bits;
    private Double difficulty;
    private String chainwork;
    private String previousblockhash;
    private String nextblockhash;
}

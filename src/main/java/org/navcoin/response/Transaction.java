package org.navcoin.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.navcoin.response.transaction.Vin;
import org.navcoin.response.transaction.Vout;

@Data
@NoArgsConstructor
public class Transaction {
    private String hex;
    private String txid;
    private String hash;
    private Integer size;
    private Integer vsize;
    private Integer version;
    private long locktime;
    @JsonProperty("anon-destination")
    private String anonDestination;
    private Vin[] vin;
    private Vout[] vout;
    private String blockhash;
    private Integer height;
    private Integer confirmations;
    private long time;
    private long blocktime;
    private String strdzeel;
}

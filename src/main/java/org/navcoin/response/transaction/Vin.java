package org.navcoin.response.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vin {
    private String coinbase;
    private String zerocoinspend;
    private String txid;
    private Integer vout;
    private ScriptSig scriptSig;
    private Double value;
    private Double valueSat;
    private Long sequence;
    private String[] txinwitness;
    private String address;
    private String zeroct_spend;
}

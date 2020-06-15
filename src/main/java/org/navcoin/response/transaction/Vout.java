package org.navcoin.response.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vout {
    private Double value;
    private Double valueSat;
    private Long n;
    private ScriptPubKey scriptPubKey;
    private String spentTxId;
    private Integer spentIndex;
    private Integer spentHeight;
}

package org.navcoin.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRequest {
    private Integer version;
    private String hash;
    private String blockHash;
    private String proposalHash;
    private String description;
    private Double requestedAmount;
    private Integer votesYes;
    private Integer votesNo;
    private Integer votingCycle;
    private Integer state;
    private String status;
    private String stateChangedOnBlock;
    private String paidOnBlock;
}

package org.navcoin.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentRequest {
    private Integer version;
    private String hash;
    private String blockHash;
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

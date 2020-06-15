package org.navcoin.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Proposal {
    private Integer version;
    private String hash;
    private String blockHash;
    private String description;
    private Double requestedAmount;
    private Double notPaidYet;
    private Double notRequestedYet;
    private Double userPaidFee;
    private String paymentAddress;
    private Long proposalDuration;
    private Integer votesYes;
    private Integer votesNo;
    private Integer votingCycle;
    private Integer state;
    private String status;
    private String stateChangedOnBlock;
    private Long expiresOn;
    private List<PaymentRequest> paymentRequests = new ArrayList<PaymentRequest>();
}

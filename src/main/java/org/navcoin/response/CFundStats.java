package org.navcoin.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CFundStats {
    private CFundStats.Funds funds = new CFundStats.Funds();
    private CFundStats.Consensus consensus = new CFundStats.Consensus();
    private CFundStats.VotingPeriod votingPeriod = new CFundStats.VotingPeriod();

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class VotingPeriod {
        int starting;
        int ending;
        int current;
    }

    @Data
    public class Consensus {
        int blocksPerVotingCycle;
        int minSumVotesPerVotingCycle;
        int maxCountVotingCycleProposals;
        int maxCountVotingCyclePaymentRequests;
        int votesAcceptProposalPercentage;
        int votesRejectProposalPercentage;
        int votesAcceptPaymentRequestPercentage;
        int votesRejectPaymentRequestPercentage;
        int proposalMinimalFee;
    }

    @Data
    public class Funds {
        Double available;
        Double locked;
    }
}

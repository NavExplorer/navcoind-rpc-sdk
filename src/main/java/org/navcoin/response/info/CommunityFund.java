package org.navcoin.response.info;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommunityFund {
    private Double available;
    private Double locked;
}

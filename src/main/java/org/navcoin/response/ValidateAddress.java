package org.navcoin.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidateAddress {
    Boolean isvalid;
    String address;
    String scriptPubKey;
    String stakingaddress;
    String spendingaddress;
    Boolean ismine;
    Boolean isstakable;
    Boolean iswatchonly;
    Boolean isscript;
    Boolean iscoldstaking;
    String pubkey;
    Boolean iscompressed;
    String account = "";
    String hdkeypath;
    String hdmasterkeyid;
    Boolean dnssec;
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.navcoin.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.navcoin.response.info.CommunityFund;
import org.navcoin.response.info.PrivateMoneySupply;

@Data
@NoArgsConstructor
public class Info {
    private long version;
    private long protocolversion;
    private long walletversion;
    @Deprecated
    private Double balance;
    private Double public_balance;
    private Double private_balance;
    private Double coldstaking_balance;
    private Double immature_balance;
    private Double unconfirmed_balance;
    private Double newmint;
    private Double stake;
    private long blocks;
    private CommunityFund communityfund;
    private Double publicmoneysupply;
    private PrivateMoneySupply privatemoneysupply;
    private Double totalmoneysupply;
    private long timeoffset;
    private long ntptimeoffset;
    private long connections;
    private String proxy;
    private boolean testnet;
    private long keypoololdest;
    private long keypoolsize;
    private Double paytxfee;
    private Double relayfee;
    private String errors;
    private Integer unlocked_until;
}

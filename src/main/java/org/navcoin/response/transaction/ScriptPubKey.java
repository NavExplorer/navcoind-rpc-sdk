package org.navcoin.response.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ScriptPubKey {
    private String asm;
    private String hex;
    private Integer reqSigs;
    private String type;
    private List<String> addresses;
    private String hash;
}

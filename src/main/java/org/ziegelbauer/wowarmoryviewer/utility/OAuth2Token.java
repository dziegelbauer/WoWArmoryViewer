package org.ziegelbauer.wowarmoryviewer.utility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class OAuth2Token {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    public String tokenType;
    @JsonProperty("expires_in")
    public int expiresIn;
    @JsonProperty("sub")
    public String sub;
}

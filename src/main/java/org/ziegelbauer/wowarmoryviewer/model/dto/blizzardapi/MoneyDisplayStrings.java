package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MoneyDisplayStrings {
    @JsonProperty("header")
    private String header;
    @JsonProperty("gold")
    private Integer gold;
    @JsonProperty("silver")
    private Integer silver;
    @JsonProperty("copper")
    private Integer copper;
}

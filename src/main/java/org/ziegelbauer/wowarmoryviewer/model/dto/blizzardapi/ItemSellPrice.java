package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemSellPrice {
    @JsonProperty("value")
    private Integer value;
    @JsonProperty("display_strings")
    private MoneyDisplayStrings displayStrings;
}

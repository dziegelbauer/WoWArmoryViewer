package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemArmor {
    @JsonProperty("value")
    private Integer value;
    @JsonProperty("display")
    private DisplayData display;
}

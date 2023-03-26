package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemNameDescription {
    @JsonProperty("display_string")
    private String displayString;
    @JsonProperty("color")
    private ItemColor color;
}

package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemTransmog {
    @JsonProperty("item")
    private ItemHeader item;
    @JsonProperty("display_string")
    private String displayString;
    @JsonProperty("item_modified_appearance_id")
    private Integer itemModifiedAppearanceId;
}

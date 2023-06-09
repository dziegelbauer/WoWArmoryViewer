package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemSlotHeader {
    @JsonProperty("type")
    private ItemSlot slotType;
    @JsonProperty("name")
    private String name;
}

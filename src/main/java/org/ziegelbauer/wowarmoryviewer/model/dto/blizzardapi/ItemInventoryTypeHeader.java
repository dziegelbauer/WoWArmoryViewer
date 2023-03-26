package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemInventoryTypeHeader {
    @JsonProperty("type")
    private String inventoryType;
    @JsonProperty("name")
    private String name;
}

package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemQualityHeader {
    @JsonProperty("type")
    private ItemQuality qualityType;
    @JsonProperty("name")
    private String name;
}

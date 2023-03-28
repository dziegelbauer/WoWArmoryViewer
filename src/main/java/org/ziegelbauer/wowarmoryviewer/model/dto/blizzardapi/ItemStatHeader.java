package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemStatHeader {
    @JsonProperty("type")
    private StatType statType;
    @JsonProperty("name")
    private String name;
}

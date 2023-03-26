package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemModifiedCraftingStat {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String statType;
    @JsonProperty("name")
    private String name;
}

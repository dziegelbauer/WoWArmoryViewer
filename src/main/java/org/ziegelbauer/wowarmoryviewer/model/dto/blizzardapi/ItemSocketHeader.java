package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemSocketHeader {
    @JsonProperty("type")
    private String socketType;
    @JsonProperty("name")
    private String name;
}

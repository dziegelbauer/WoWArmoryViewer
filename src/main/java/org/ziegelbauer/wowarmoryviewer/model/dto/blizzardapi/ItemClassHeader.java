package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemClassHeader {
    @JsonProperty("key")
    private ApiUrl url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private Integer id;
}

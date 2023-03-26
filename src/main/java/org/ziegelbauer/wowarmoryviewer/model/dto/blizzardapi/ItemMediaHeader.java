package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemMediaHeader {
    @JsonProperty("key")
    private ApiUrl url;
    @JsonProperty("id")
    private Integer id;
}

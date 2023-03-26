package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemBindingHeader {
    @JsonProperty("type")
    private String bindingType;
    @JsonProperty("name")
    private String name;
}

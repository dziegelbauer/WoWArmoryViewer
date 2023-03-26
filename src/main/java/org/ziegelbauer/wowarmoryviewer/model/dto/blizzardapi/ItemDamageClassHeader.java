package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemDamageClassHeader {
    @JsonProperty("type")
    private String damageType;
    @JsonProperty("name")
    private String name;
}

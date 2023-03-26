package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemAttackSpeed {
    @JsonProperty("value")
    private Integer value;
    @JsonProperty("display_string")
    private String displayString;
}

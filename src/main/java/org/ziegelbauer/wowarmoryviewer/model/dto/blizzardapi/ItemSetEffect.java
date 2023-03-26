package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemSetEffect {
    @JsonProperty("display_string")
    private String displayString;
    @JsonProperty("required_count")
    private Integer requiredCount;
    @JsonProperty("is_active")
    private Boolean isActive;
}

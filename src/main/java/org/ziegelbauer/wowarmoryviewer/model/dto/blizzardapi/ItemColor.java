package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemColor {
    @JsonProperty("r")
    private Integer red;
    @JsonProperty("g")
    private Integer green;
    @JsonProperty("b")
    private Integer blue;
    @JsonProperty("a")
    private Double alpha;
}

package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemWeaponDamage {
    @JsonProperty("min_value")
    private Integer minValue;
    @JsonProperty("max_value")
    private Integer maxValue;
    @JsonProperty("display_string")
    private String displayString;
    @JsonProperty("damage_class")
    private ItemDamageClassHeader damageClass;
}

package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemStat {
    @JsonProperty("type")
    private ItemStatHeader statType;
    @JsonProperty("value")
    private Integer value;
    @JsonProperty("display")
    private DisplayData displayData;
    @JsonProperty("is_negated")
    private Boolean isNegated;
    @JsonProperty("is_equip_bonus")
    private Boolean isEquipBonus;
}

package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemEnchantmentSlotHeader {
    @JsonProperty("id")
    private Integer Id;
    @JsonProperty("type")
    private String slotType;
}

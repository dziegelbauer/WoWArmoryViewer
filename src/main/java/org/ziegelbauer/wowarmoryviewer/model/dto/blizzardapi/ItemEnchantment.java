package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemEnchantment {
    @JsonProperty("display_string")
    private String displayString;
    @JsonProperty("source_item")
    private ItemHeader sourceItem;
    @JsonProperty("enchantment_id")
    private Integer enchantmentId;
    @JsonProperty("enchantment_slot")
    private ItemEnchantmentSlotHeader enchantmentSlot;
}

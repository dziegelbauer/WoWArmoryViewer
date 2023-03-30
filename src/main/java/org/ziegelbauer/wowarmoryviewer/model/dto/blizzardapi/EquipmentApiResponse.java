package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

@Data
public class EquipmentApiResponse {
    @JsonProperty("_links")
    private ApiHeader apiHeader;
    @JsonProperty("character")
    private CharacterHeader characterHeader;
    @JsonProperty("equipped_items")
    public Collection<Item> equippedItems;
    @JsonProperty("equipped_item_sets")
    public Collection<ItemSet> itemSets;
}

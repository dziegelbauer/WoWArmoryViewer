package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemSetItem {
    @JsonProperty("item")
    private ItemHeader item;
    @JsonProperty("is_equipped")
    private Boolean isEquipped;
}

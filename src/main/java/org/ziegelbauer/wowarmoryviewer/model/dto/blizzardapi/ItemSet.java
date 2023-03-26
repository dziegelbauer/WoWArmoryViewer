package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

@Data
public class ItemSet {
    @JsonProperty("item_set")
    private ItemSetHeader itemSetHeader;
    @JsonProperty("items")
    private Collection<ItemSetItem> items;
    @JsonProperty("effects")
    private Collection<ItemSetEffect> effects;
    @JsonProperty("display_string")
    private String displayString;
}

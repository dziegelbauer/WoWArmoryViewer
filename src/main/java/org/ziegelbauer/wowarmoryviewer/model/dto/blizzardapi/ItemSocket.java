package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

@Data
public class ItemSocket {
    @JsonProperty("socket_type")
    private ItemSocketHeader itemSocketHeader;
    @JsonProperty("item")
    private ItemHeader item;
    @JsonProperty("context")
    private Integer context;
    @JsonProperty("bonus_list")
    private Collection<Integer> bonusList;
    @JsonProperty("display_string")
    private String displayString;
    @JsonProperty("media")
    private ItemMediaHeader mediaHeader;
    @JsonProperty("item_level")
    private Integer itemLevel;
    @JsonProperty("display_color")
    private ItemColor displayColor;
}

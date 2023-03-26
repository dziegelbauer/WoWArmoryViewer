package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemSocket {
    @JsonProperty("socket_type")
    private ItemSocketHeader itemSocketHeader;
    @JsonProperty("item")
    private ItemHeader item;
    @JsonProperty("display_string")
    private String displayString;
    @JsonProperty("media")
    private ItemMediaHeader mediaHeader;
}

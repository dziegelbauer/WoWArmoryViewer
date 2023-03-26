package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemSpellHeader {
    @JsonProperty("key")
    private ApiUrl url;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
}

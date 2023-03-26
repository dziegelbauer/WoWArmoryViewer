package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemSpell {
    @JsonProperty("spell")
    private ItemSpellHeader spellHeader;
    @JsonProperty("description")
    private String description;
}

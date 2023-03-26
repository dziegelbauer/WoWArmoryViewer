package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

@Data
public class ItemRequirements {
    @JsonProperty("level")
    private ItemLevelRequirement level;
    @JsonProperty("playable_classes")
    private PlayableClassRequirement playableClassRequirement;
}

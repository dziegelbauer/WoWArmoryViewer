package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

@Data
public class PlayableClassRequirement {
    @JsonProperty("links")
    private Collection<PlayableClass> playableClasses;
    @JsonProperty("display_string")
    private String displayString;

}

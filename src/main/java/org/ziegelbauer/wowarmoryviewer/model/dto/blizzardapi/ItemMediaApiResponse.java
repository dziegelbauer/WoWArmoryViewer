package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

@Data
public class ItemMediaApiResponse {
    @JsonProperty("_links")
    private ApiHeader apiHeader;
    @JsonProperty("assets")
    private Collection<MediaAsset> assets;
    @JsonProperty("id")
    private Integer id;
}

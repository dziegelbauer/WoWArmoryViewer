package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MediaAsset {
    @JsonProperty("key")
    private String assetType;
    @JsonProperty("value")
    private String url;
    @JsonProperty("file_data_id")
    private Integer fileDataId;
}

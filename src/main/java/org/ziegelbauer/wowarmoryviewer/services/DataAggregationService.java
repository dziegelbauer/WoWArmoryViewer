package org.ziegelbauer.wowarmoryviewer.services;

import org.ziegelbauer.wowarmoryviewer.model.dto.ItemData;

import java.util.List;

public interface DataAggregationService {
    byte[] getItemIcon(Integer id);
    List<ItemData> getItemData(String realmSlug, String name);
}

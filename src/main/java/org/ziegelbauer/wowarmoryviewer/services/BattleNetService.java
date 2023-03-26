package org.ziegelbauer.wowarmoryviewer.services;

import org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi.EquipmentApiResponse;

public interface BattleNetService {
    EquipmentApiResponse getCharacterEquipment(String realmSlug, String name);
    byte[] getItemIcon(Integer itemId);
}

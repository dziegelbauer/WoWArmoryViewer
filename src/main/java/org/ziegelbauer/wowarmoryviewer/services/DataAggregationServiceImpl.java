package org.ziegelbauer.wowarmoryviewer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ziegelbauer.wowarmoryviewer.model.dto.ItemData;
import org.ziegelbauer.wowarmoryviewer.model.dto.ItemTooltipLine;
import org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi.Item;
import org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi.ItemColor;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataAggregationServiceImpl implements DataAggregationService {
    private final BattleNetService battleNetService;
    private final DataCacheService dataCacheService;

    public DataAggregationServiceImpl(
            BattleNetService battleNetService,
            DataCacheService dataCacheService
    ) {
        this.battleNetService = battleNetService;
        this.dataCacheService = dataCacheService;
    }

    @Override
    public byte[] getItemIcon(Integer id) {
        return new byte[0];
    }

    @Override
    public List<ItemData> getItemData(String realmSlug, String name) {
        var itemList = new ArrayList<>();
        var characterData = battleNetService.getCharacterEquipment(realmSlug, name);

        for (Item item : characterData.getEquippedItems()) {
            var itemData = new ItemData();
            itemData.setItemIcon(dataCacheService.getItemIcon(item.getItemHeader().getId()));
            itemData.setLines(new ArrayList<>());
            ItemColor lineColor =
                switch (item.getItemQualityHeader().getQualityType()) {
                    case "POOR" -> new ItemColor(157, 157, 157, 1.0);
                    case "COMMON" -> new ItemColor(255, 255, 255, 1.0);
                    case "UNCOMMON" -> new ItemColor(30, 255, 0, 1.0);
                    case "RARE" -> new ItemColor(0, 112, 221, 1.0);
                    case "EPIC" -> new ItemColor(163, 53, 238, 1.0);
                    case "LEGENDARY" -> new ItemColor(255, 128, 0, 1.0);
                    case "ARTIFACT" -> new ItemColor(230, 204, 128, 1.0);
                    case "HEIRLOOM" -> new ItemColor(0, 204, 255, 1.0);
                };
            itemData.getLines().add(new ItemTooltipLine(lineColor, item.getName()));

        }

        return null;
    }
}

package org.ziegelbauer.wowarmoryviewer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ziegelbauer.wowarmoryviewer.model.dto.ItemData;
import org.ziegelbauer.wowarmoryviewer.model.dto.ItemTooltipLine;
import org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi.*;

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
        List<ItemData> itemList = new ArrayList<>();
        var characterData = battleNetService.getCharacterEquipment(realmSlug, name);

        for (Item item : characterData.getEquippedItems()) {
            itemList.add(convertItemData(item));
        }

        return itemList;
    }

    private ItemData convertItemData(Item item) {
        var itemData = new ItemData();
        itemData.setItemIcon(dataCacheService.getItemIcon(item.getItemHeader().getId()));
        itemData.setLines(new ArrayList<>());

        ItemColor lineColor =
                switch (item.getItemQualityHeader().getQualityType()) {
                    case POOR -> new ItemColor(157, 157, 157, 1.0);
                    case COMMON -> new ItemColor(255, 255, 255, 1.0);
                    case UNCOMMON -> new ItemColor(30, 255, 0, 1.0);
                    case RARE -> new ItemColor(0, 112, 221, 1.0);
                    case EPIC -> new ItemColor(163, 53, 238, 1.0);
                    case LEGENDARY -> new ItemColor(255, 128, 0, 1.0);
                    case ARTIFACT -> new ItemColor(230, 204, 128, 1.0);
                    case HEIRLOOM -> new ItemColor(0, 204, 255, 1.0);
                };
        itemData.getLines().add(new ItemTooltipLine(lineColor, item.getName()));

        if(item.getNameDescription() != null) {
            itemData.getLines().add(new ItemTooltipLine(
                    item.getNameDescription().getColor(),
                    item.getNameDescription().getDisplayString()
            ));
        }

        if(item.getLevel() != null) {
            itemData.getLines().add(new ItemTooltipLine(
                    new ItemColor(250, 200, 0, 1.0),
                    item.getLevel().getDisplayString()
            ));
        }

        if(item.getTransmog() != null) {
            itemData.getLines().add(new ItemTooltipLine(
                    new ItemColor(255, 130, 255, 1.0),
                    item.getTransmog().getDisplayString()
            ));
        }

        if(item.getItemBindingHeader() != null) {
            itemData.getLines().add(new ItemTooltipLine(
                    new ItemColor(255, 255, 255, 1.0),
                    item.getItemBindingHeader().getName()
            ));
        }

        if(item.getUniqueEquipped() != null) {
            itemData.getLines().add(new ItemTooltipLine(
                    new ItemColor(255, 255, 255, 1.0),
                    item.getUniqueEquipped()
            ));
        }

        if(item.getItemInventoryTypeHeader() != null) {
            StringBuilder itemTypeLine = new StringBuilder();
            itemTypeLine.append(item.getItemInventoryTypeHeader().getName());
            if(item.getItemSubClassHeader() != null) {
                if(item.getIsSubclassHidden() == null || item.getIsSubclassHidden() == false) {
                    itemTypeLine.append("\t");
                    itemTypeLine.append(item.getItemSubClassHeader().getName());
                }
            }
            itemData.getLines().add(new ItemTooltipLine(
                    new ItemColor(255, 255, 255, 1.0),
                    itemTypeLine.toString()
            ));
        }

        if(item.getWeapon() != null) {
            StringBuilder itemWeaponLine = new StringBuilder();
            itemWeaponLine.append(item.getWeapon().getDamage().getDisplayString());
            itemWeaponLine.append("\t");
            itemWeaponLine.append(item.getWeapon().getAttackSpeed().getDisplayString());
            itemData.getLines().add(new ItemTooltipLine(
                    new ItemColor(255, 255, 255, 1.0),
                    itemWeaponLine.toString()
            ));
            itemData.getLines().add(new ItemTooltipLine(
                    new ItemColor(255, 255, 255, 1.0),
                    item.getWeapon().getDps().getDisplayString()
            ));
        }

        if(item.getStats() != null) {

            var primaryStat = item.getStats()
                    .stream()
                    .filter(stat ->
                            (stat.getStatType().getStatType() == StatType.AGILITY
                                    || stat.getStatType().getStatType() == StatType.STRENGTH
                                    || stat.getStatType().getStatType() == StatType.INTELLECT)
                                    && (stat.getIsNegated() == null || stat.getIsNegated() == false))
                    .findFirst();
            primaryStat.ifPresent(itemStat -> itemData.getLines().add(new ItemTooltipLine(
                    new ItemColor(255, 255, 255, 1.0),
                    itemStat.getDisplayData().getDisplayString()
            )));

            var staminaStat = item.getStats()
                    .stream()
                    .filter(stat -> stat.getStatType().getStatType() == StatType.STAMINA)
                    .findFirst();
            staminaStat.ifPresent(itemStat -> itemData.getLines().add(new ItemTooltipLine(
                    new ItemColor(255, 255, 255, 1.0),
                    itemStat.getDisplayData().getDisplayString()
            )));

            var secondaryStats = item.getStats()
                    .stream()
                    .filter(itemStat ->
                            itemStat.getStatType().getStatType() == StatType.VERSATILITY
                                    || itemStat.getStatType().getStatType() == StatType.CRIT_RATING
                                    || itemStat.getStatType().getStatType() == StatType.MASTERY_RATING
                                    || itemStat.getStatType().getStatType() == StatType.HASTE_RATING)
                    .toList();
            for (ItemStat itemStat : secondaryStats) {
                itemData.getLines().add(new ItemTooltipLine(
                        new ItemColor(0, 255, 0, 1.0),
                        itemStat.getDisplayData().getDisplayString()
                ));
            }

            var inactivePrimaryStats = item.getStats()
                    .stream()
                    .filter(itemStat ->
                            (itemStat.getStatType().getStatType() == StatType.AGILITY
                                    || itemStat.getStatType().getStatType() == StatType.INTELLECT
                                    || itemStat.getStatType().getStatType() == StatType.STRENGTH)
                                    && (itemStat.getIsNegated() != null && itemStat.getIsNegated()))
                    .toList();
            for (ItemStat itemStat : inactivePrimaryStats) {
                itemData.getLines().add(new ItemTooltipLine(
                        new ItemColor(105, 105, 105, 1.0),
                        itemStat.getDisplayData().getDisplayString()
                ));
            }
        }

        itemData.getLines().add(new ItemTooltipLine(
                new ItemColor(255, 255, 255, 1.0),
                ""));

        if(item.getEnchantments() != null) {
            for(ItemEnchantment enchanment : item.getEnchantments()) {
                itemData.getLines().add(new ItemTooltipLine(
                        new ItemColor(0, 255, 0, 1.0),
                        enchanment.getDisplayString()
                ));
            }
        }

        if(item.getSpells() != null) {
            for(ItemSpell spell : item.getSpells()) {
                itemData.getLines().add(new ItemTooltipLine(
                        new ItemColor(0, 255, 0, 1.0),
                        spell.getDescription()
                ));
            }
        }

        return itemData;
    }
}

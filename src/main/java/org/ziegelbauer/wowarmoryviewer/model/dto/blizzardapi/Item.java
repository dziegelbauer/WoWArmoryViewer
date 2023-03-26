package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;

@Data
public class Item {
    @JsonProperty("item")
    private ItemHeader itemHeader;
    @JsonProperty("enchantments")
    private Collection<ItemEnchantment> enchantments;
    @JsonProperty("sockets")
    private Collection<ItemSocket> itemSockets;
    @JsonProperty("slot")
    private ItemSlotHeader itemSlotHeader;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("context")
    private Integer context;
    @JsonProperty("bonus_list")
    private Collection<Integer> bonusList;
    @JsonProperty("quality")
    private ItemQualityHeader itemQualityHeader;
    @JsonProperty("name")
    private String name;
    @JsonProperty("modified_appearance_id")
    private Integer modifiedAppearanceId;
    @JsonProperty("media")
    private ItemMediaHeader mediaHeader;
    @JsonProperty("item_class")
    private ItemClassHeader itemClassHeader;
    @JsonProperty("item_subclass")
    private ItemSubClassHeader itemSubClassHeader;
    @JsonProperty("inventory_type")
    private ItemInventoryTypeHeader itemInventoryTypeHeader;
    @JsonProperty("binding")
    private ItemBindingHeader itemBindingHeader;
    @JsonProperty("unique_equipped")
    private String uniqueEquipped;
    @JsonProperty("limit_category")
    private String limitCategory;
    @JsonProperty("weapon")
    private ItemWeaponData weapon;
    @JsonProperty("armor")
    private ItemArmor armor;
    @JsonProperty("stats")
    private Collection<ItemStat> stats;
    @JsonProperty("spells")
    private Collection<ItemSpell> spells;
    @JsonProperty("sell_price")
    private ItemSellPrice sellPrice;
    @JsonProperty("requirements")
    private ItemRequirements requirements;
    @JsonProperty("description")
    private String description;
    @JsonProperty("set")
    private ItemSet itemSet;
    @JsonProperty("level")
    private ItemLevel level;
    @JsonProperty("is_subclass_hidden")
    private Boolean isSubclassHidden;
    @JsonProperty("modified_crafting_stat")
    private Collection<ItemModifiedCraftingStat> modifiedCraftingStats;
    @JsonProperty("transmog")
    private ItemTransmog transmog;
    @JsonProperty("durability")
    private ItemDurability durability;
    @JsonProperty("name_description")
    private ItemNameDescription nameDescription;
}

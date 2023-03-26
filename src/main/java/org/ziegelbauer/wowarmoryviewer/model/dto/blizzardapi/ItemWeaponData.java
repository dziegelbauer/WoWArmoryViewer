package org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemWeaponData {
    @JsonProperty("damage")
    private ItemWeaponDamage damage;
    @JsonProperty("attack_speed")
    private ItemAttackSpeed attackSpeed;
    @JsonProperty("dps")
    private ItemDps dps;
}

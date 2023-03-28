package org.ziegelbauer.wowarmoryviewer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi.ItemSlot;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemData {
    private byte[] itemIcon;
    private ItemSlot equippedSlot;
    private List<ItemTooltipLine> lines;
}

package org.ziegelbauer.wowarmoryviewer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemData {
    private byte[] itemIcon;
    private List<ItemTooltipLine> lines;
}

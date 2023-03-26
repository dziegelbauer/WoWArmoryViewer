package org.ziegelbauer.wowarmoryviewer.model.dto;

import lombok.*;
import org.ziegelbauer.wowarmoryviewer.model.dto.blizzardapi.ItemColor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ItemTooltipLine {
    private ItemColor color;
    private String text;
}

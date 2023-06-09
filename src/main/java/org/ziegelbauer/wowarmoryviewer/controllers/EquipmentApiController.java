package org.ziegelbauer.wowarmoryviewer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ziegelbauer.wowarmoryviewer.model.dto.ApiResponse;
import org.ziegelbauer.wowarmoryviewer.services.DataAggregationService;

@RestController
@AllArgsConstructor
public class EquipmentApiController {
    private final DataAggregationService dataAggregationService;

    @GetMapping(value = "/api/v1/equipment/{realmSlug}/{name}", produces = "application/json")
    public ApiResponse getCharacterEquipment(
            @PathVariable String realmSlug,
            @PathVariable String name)
    {
        var equipmentData = dataAggregationService.getItemData(realmSlug, name);
        return new ApiResponse(true, equipmentData);
    }
}

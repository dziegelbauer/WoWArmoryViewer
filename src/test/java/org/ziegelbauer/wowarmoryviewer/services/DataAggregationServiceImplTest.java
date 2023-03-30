package org.ziegelbauer.wowarmoryviewer.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataAggregationServiceImplTest {
    @Autowired
    private DataAggregationService dataAggregationService;

    @Test
    void getItemIcon() {
    }

    @Test
    void getItemData() {
        var data = dataAggregationService.getItemData("thrall", "naelran");

        assert data != null;
    }
}
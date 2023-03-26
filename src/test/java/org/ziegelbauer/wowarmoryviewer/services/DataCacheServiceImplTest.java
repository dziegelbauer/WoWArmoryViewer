package org.ziegelbauer.wowarmoryviewer.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DataCacheServiceImplTest {
    @Autowired
    private DataCacheService dataCacheService;
    @Test
    void getItemIcon() {
        var iconData = dataCacheService.getItemIcon(19019);
        assert iconData != null;
        var iconData2 = dataCacheService.getItemIcon(19019);
        assert iconData2 != null;

        assert iconData.length == iconData2.length;

        for(int i = 0; i < iconData.length; i++){
            assert iconData[i] == iconData2[i];
        }
    }
}
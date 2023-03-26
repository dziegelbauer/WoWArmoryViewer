package org.ziegelbauer.wowarmoryviewer.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BattleNetProfileWebServiceTest {
    @Autowired
    BattleNetServiceImpl bnps;

    @Test
    void getCharacterEquipment() {
        var equip = bnps.getCharacterEquipment("thrall", "naelran");

        assert equip != null;
    }
}
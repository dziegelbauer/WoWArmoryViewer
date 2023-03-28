package org.ziegelbauer.wowarmoryviewer.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BattleNetServiceImplTest {
    @Autowired
    BattleNetServiceImpl battleNetService;

    @Test
    void getCharacterEquipment() {
        var equip = battleNetService.getCharacterEquipment("thrall", "naelran");

        assert equip != null;
    }
}
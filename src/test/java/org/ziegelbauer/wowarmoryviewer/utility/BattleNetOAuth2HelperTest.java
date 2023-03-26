package org.ziegelbauer.wowarmoryviewer.utility;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BattleNetOAuth2HelperTest {
    @Autowired
    private BattleNetOAuth2Helper battleNetOAuth2Helper;

    @Test
    void getToken() {
        String apiToken = battleNetOAuth2Helper.getToken();
        assert apiToken != null;
    }
}
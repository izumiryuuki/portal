package com.portal.z.common.domain.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * com.portal.z.common.domain.util.Utility のテストクラス
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = { "DATASOURCE_URL= jdbc:postgresql://localhost:5432/SAMPLE",
        "DATASOURCE_PASSWORD=admin", "DATASOURCE_USERNAME=postgres" })
class UtilityTest {

    /*
     * 注意：
     * 環境変数を変更している場合、@TestPropertySourceの設定を変更してください。
     *   【標準の設定】
     *   DATASOURCE_URL jdbc:postgresql://localhost:5432/SAMPLE
     *   DATASOURCE_USERNAME postgres
     *   DATASOURCE_PASSWORD admin
     */

    //
    // getFile
    //
    @Test
    final void testGetFile() {
        // fail("未作成。必ずエラーになります。"); // TODO あとでつくる。(Javaビギナー用の課題)
    }
}

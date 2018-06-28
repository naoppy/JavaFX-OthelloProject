package naoppy.othello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OthelloFieldTest {
    private OthelloField field = new OthelloField();

    @Test
    void toStringTest() {
        String expectedString =
                "        " +
                        "\n        " +
                        "\n        " +
                        "\n   ox   " +
                        "\n   xo   " +
                        "\n        " +
                        "\n        " +
                        "\n        ";
        assertEquals(expectedString, field.toString());
    }

    @Test
    void nextIsWhiteTest() {
        assertTrue(field.getNextIsWhite());
    }

    @Test
    void putNewKomaCanPutUpperClose() {
        assertTrue(field.putNewKoma(2,4), "縦に挟めるはず");
    }

    @Test
    void putNewKomaByEnemyCanPut() {
        field.setNextIsWhite(false);
        assertTrue( field.putNewKoma(2,3), "黒の駒はここに置けなければならない");
    }

    @Test
    void putNewKomaByEnemy() {
        field.setNextIsWhite(false);
        field.putNewKoma(2,3);

        String expectedString =
                "        " +
                        "\n        " +
                        "\n   x    " +
                        "\n   xx   " +
                        "\n   xo   " +
                        "\n        " +
                        "\n        " +
                        "\n        ";
        assertEquals(expectedString, field.toString(), "黒のプレイヤーも駒をはさめるか");
    }

    @Test
    void putNewKomaBadPointFailTest() {
        assertFalse(field.putNewKoma(1,1) ,"何も挟めないなら置けない");
    }

    @Test
    void putNewKomaOverExsitedKomaFailTest() {
        assertFalse(field.putNewKoma(3,3) ,"既に置いてある駒の上に置けない");
    }

    @Test
    void putNewKomaUpdateUpperClose() {
        field.putNewKoma(2,4);

        String expectedString =
                "        " +
                        "\n        " +
                        "\n    o   " +
                        "\n   oo   " +
                        "\n   xo   " +
                        "\n        " +
                        "\n        " +
                        "\n        ";
        assertEquals(expectedString, field.toString(), "縦に挟めなければいけない");
    }

    @Test
    void putNewKomaUpdateDownerClose() {
        field.putNewKoma(5,3);

        String expectedString =
                "        " +
                        "\n        " +
                        "\n        " +
                        "\n   ox   " +
                        "\n   oo   " +
                        "\n   o    " +
                        "\n        " +
                        "\n        ";
        assertEquals(expectedString, field.toString(), "縦に挟めなければいけない");
    }

    @Test
    void putNewKomaUpdateRightClose() {
        field.putNewKoma(3,5);

        String expectedString =
                "        " +
                        "\n        " +
                        "\n        " +
                        "\n   ooo  " +
                        "\n   xo   " +
                        "\n        " +
                        "\n        " +
                        "\n        ";
        assertEquals(expectedString, field.toString(), "右と挟めなければいけない");
    }

    @Test
    void putNewKomaUpdateLeftClose() {
        field.putNewKoma(4,2);

        String expectedString =
                "        " +
                        "\n        " +
                        "\n        " +
                        "\n   ox   " +
                        "\n  ooo   " +
                        "\n        " +
                        "\n        " +
                        "\n        ";
        assertEquals(expectedString, field.toString(), "左と挟めなければいけない");
    }

    @Test
    void putNewKomaUpdateUpper_Right() {
        field.putNewKoma(3,5);
        field.putNewKoma(2,5);

        String expectedString =
                "        " +
                        "\n        " +
                        "\n     x  " +
                        "\n   oxo  " +
                        "\n   xo   " +
                        "\n        " +
                        "\n        " +
                        "\n        ";
        assertEquals(expectedString, field.toString(), "右上と挟めなければいけない");
    }
}
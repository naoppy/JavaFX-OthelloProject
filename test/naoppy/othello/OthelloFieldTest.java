package naoppy.othello;

import org.junit.jupiter.api.BeforeAll;
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
}
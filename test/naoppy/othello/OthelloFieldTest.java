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
        assertTrue(field.getIsNextIsWhite());
    }
}
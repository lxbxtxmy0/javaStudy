import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanFormatTest {
    NumberFormat tools = new RomanFormat();

    @Test
    void parse() {
        assertThrows(IllegalArgumentException.class, () -> tools.parse(null));
        assertThrows(IllegalArgumentException.class, () -> tools.parse(""));
        assertThrows(IllegalArgumentException.class, () -> tools.parse("0"));
        assertThrows(IllegalArgumentException.class, () -> tools.parse("XXXX"));
        assertThrows(IllegalArgumentException.class, () -> tools.parse("XXIIX"));
        assertThrows(IllegalArgumentException.class, () -> tools.parse("XXVV"));

        assertEquals(1, tools.parse("I"));
        assertEquals(2, tools.parse("II"));
        assertEquals(10, tools.parse("X"));
        assertEquals(38, tools.parse("XXXVIII"));
        assertEquals(39, tools.parse("XXXIX"));
    }

    @Test
    void format() {
        assertThrows(IllegalArgumentException.class, () -> tools.format(-1));
        assertThrows(IllegalArgumentException.class, () -> tools.format(0));
        assertThrows(IllegalArgumentException.class, () -> tools.format(40));
        assertThrows(IllegalArgumentException.class, () -> tools.format(50));

        assertEquals("I", tools.format(1));
        assertEquals("II", tools.format(2));
        assertEquals("XVI", tools.format(16));
        assertEquals("XXXVIII", tools.format(38));
        assertEquals("XXXIX", tools.format(39));
    }

}
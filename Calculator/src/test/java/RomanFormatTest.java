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
        assertEquals(16, tools.parse("XVI"));
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

    @Test
    void matches() {
        assertFalse(tools.matches("0"));
        assertFalse(tools.matches(""));
        assertFalse(tools.matches(null));
        assertFalse(tools.matches("-1"));
        assertFalse(tools.matches("MK"));
        assertFalse(tools.matches("52"));
        assertFalse(tools.matches("XXXXXXVVIIIVIVI"));

        assertTrue(tools.matches("I"));
        assertTrue(tools.matches("XI"));
        assertTrue(tools.matches("VX"));
        assertTrue(tools.matches("XXXIX"));
    }
}
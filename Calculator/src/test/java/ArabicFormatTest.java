import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArabicFormatTest {
    NumberFormat tools = new ArabicFormat();

    @Test
    void parse() {
        assertThrows(IllegalArgumentException.class, () -> tools.parse(""));
        assertThrows(IllegalArgumentException.class, () -> tools.parse(null));
        assertThrows(IllegalArgumentException.class, () -> tools.parse("-1"));
        assertThrows(IllegalArgumentException.class, () -> tools.parse("0"));
        assertThrows(IllegalArgumentException.class, () -> tools.parse("40"));
        assertThrows(IllegalArgumentException.class, () -> tools.parse("50"));

        assertEquals(1, tools.parse("1"));
        assertEquals(2, tools.parse("2"));
        assertEquals(15, tools.parse("15"));
        assertEquals(38, tools.parse("38"));
        assertEquals(39, tools.parse("39"));
    }

    @Test
    void format() {
        assertThrows(IllegalArgumentException.class, () -> tools.format(-1));
        assertThrows(IllegalArgumentException.class, () -> tools.format(0));
        assertThrows(IllegalArgumentException.class, () -> tools.format(40));
        assertThrows(IllegalArgumentException.class, () -> tools.format(50));

        assertEquals("1", tools.format(1));
        assertEquals("2", tools.format(2));
        assertEquals("15", tools.format(15));
        assertEquals("38", tools.format(38));
        assertEquals("39", tools.format(39));
    }

    @Test
    void matches() {
        assertEquals(false, tools.matches(null));
        assertEquals(false, tools.matches(""));
        assertEquals(false, tools.matches("-1"));
        assertEquals(false, tools.matches("0"));
        assertEquals(false, tools.matches("50"));
        assertEquals(false, tools.matches("40"));

        assertEquals(true, tools.matches("1"));
        assertEquals(true, tools.matches("2"));
        assertEquals(true, tools.matches("15"));
        assertEquals(true, tools.matches("38"));
        assertEquals(true, tools.matches("39"));
    }
}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.w3c.dom.Text;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AsciiCharSequenceTest {
    AsciiCharSequence bytes = new AsciiCharSequence(new byte[] {'a', 'b', 'c', 'd'});

    @Test
    void length() {
        assertEquals(4, bytes.length());
    }

    @Test
    void charAt() {
        assertEquals('\0', bytes.charAt(-1));
        assertEquals('\0', bytes.charAt(100));

        assertEquals('a', bytes.charAt(0));
        assertEquals('d', bytes.charAt(3));
    }

    @Test
    void subSequence() {
        assertEquals("", bytes.subSequence(-1, 0).toString());
        assertEquals("", bytes.subSequence(0, 100).toString());
        assertEquals("", bytes.subSequence(-1, 100).toString());
        assertEquals("", bytes.subSequence(3, 1).toString());

        assertEquals("", bytes.subSequence(0, 0).toString());
        assertEquals("a", bytes.subSequence(0, 1).toString());
        assertEquals("ab", bytes.subSequence(0, 2).toString());
        assertEquals("bcd", bytes.subSequence(1, 4).toString());
        assertEquals("bc", bytes.subSequence(1, 3).toString());
    }

    @Test
    void testToString() {
        assertEquals("abcd", bytes.toString());
    }
}
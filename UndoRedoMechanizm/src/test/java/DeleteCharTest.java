import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteCharTest {
    StringBuilder buffer;
    Action deleteChar;

    @BeforeEach
    void setUp() {
        buffer  = new StringBuilder("abcd");
        deleteChar = new DeleteChar(buffer);
    }

    @Test
    void execute() {
        deleteChar.execute();
        assertEquals("abc", buffer.toString());
    }

    @Test
    void undo() {
        deleteChar.execute();
        deleteChar.undo();
        assertEquals("abcd", buffer.toString());

        deleteChar.execute();
        deleteChar.execute();
        deleteChar.undo();
        assertEquals("abc", buffer.toString());
    }

}
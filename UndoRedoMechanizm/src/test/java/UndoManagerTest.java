import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UndoManagerTest {
    StringBuilder buffer;
    Action deleteChar;
    UndoManager manager = new UndoManager();

    @BeforeEach
    void setUp() {
        buffer  = new StringBuilder("abcd");
        deleteChar = new DeleteChar(buffer);
    }

    @Test
    void perform() {
        manager.perform(deleteChar);
        assertEquals("abc", buffer.toString());
    }

    @Test
    void undo() {
        manager.perform(deleteChar);
        manager.undo();
        assertEquals("abcd", buffer.toString());
    }

    @Test
    void redo() {
        manager.perform(new DeleteChar(buffer));
        manager.perform(new DeleteChar(buffer));
        manager.perform(new DeleteChar(buffer));
        assertEquals("ab", buffer.toString());
    }
}
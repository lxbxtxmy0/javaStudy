import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SyntaxValidatorTest {
    SyntaxValidator tools = new SyntaxValidator();


    @Test
    void processText() {
        assertEquals(tools.processText("[[[[{{}}]]]]"), true);
    }
}
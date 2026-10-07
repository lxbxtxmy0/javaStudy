import org.junit.jupiter.api.*;
import org.w3c.dom.Text;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TextAnalyzerTest {
    TextAnalyzer spamAnalyzer = new SpamAnalyzer(new String[]{"haha", "python", "raz,dva"});
    TextAnalyzer tooLongTextAnalyzer = new TooLongTextAnalyzer(10);
    TextAnalyzer negativeTextAnalyzer = new NegativeTextAnalyzer();

    @Test
    void processText() {
        assertEquals(Label.SPAM, spamAnalyzer.processText("haha"));
        assertEquals(Label.SPAM, spamAnalyzer.processText("python"));
        assertEquals(Label.SPAM, spamAnalyzer.processText("raz,dva"));
        assertEquals(Label.OK, spamAnalyzer.processText("raz"));
        assertEquals(Label.OK, spamAnalyzer.processText(""));

        assertEquals(Label.OK, tooLongTextAnalyzer.processText(""));
        assertEquals(Label.OK, tooLongTextAnalyzer.processText("asd"));
        assertEquals(Label.OK, tooLongTextAnalyzer.processText("asdasdasda"));
        assertEquals(Label.TOO_LONG, tooLongTextAnalyzer.processText("asdasdasdaa"));

        assertEquals(Label.OK, negativeTextAnalyzer.processText("( :, : |, = ("));
        assertEquals(Label.NEGATIVE_TEXT, negativeTextAnalyzer.processText(":(, : |, = ("));
        assertEquals(Label.NEGATIVE_TEXT, negativeTextAnalyzer.processText("( :, :|, = ("));
        assertEquals(Label.NEGATIVE_TEXT, negativeTextAnalyzer.processText("( :, : |, =("));
    }
}
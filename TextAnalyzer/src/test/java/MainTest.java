import org.junit.jupiter.api.*;
import org.w3c.dom.Text;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    TextAnalyzer spamAnalyzer = new SpamAnalyzer(new String[]{"haha", "python", "raz,dva"});
    TextAnalyzer tooLongTextAnalyzer = new TooLongTextAnalyzer(10);
    TextAnalyzer negativeTextAnalyzer = new NegativeTextAnalyzer();

    TextAnalyzer[] textAnalyzers = {spamAnalyzer, tooLongTextAnalyzer, negativeTextAnalyzer};

    @Test
    void checkLabels() {
        assertEquals(Label.OK, Main.checkLabels(textAnalyzers, "hah"));

        assertEquals(Label.SPAM, Main.checkLabels(textAnalyzers, "haha, 123123213123123123123, :("));
        assertEquals(Label.SPAM, Main.checkLabels(textAnalyzers, "112312312132223123123123123123123123, haha, :("));
        assertEquals(Label.NEGATIVE_TEXT, Main.checkLabels(textAnalyzers, "h asd :(sd"));
        assertEquals(Label.TOO_LONG, Main.checkLabels(textAnalyzers, "dasdasdasdasdasdasdasdasdas"));
    }
}
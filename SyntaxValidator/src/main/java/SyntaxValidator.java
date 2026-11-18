import java.util.*;

public class SyntaxValidator {
    private final String leftBrackets = "{[(";
    private final String rightBrackets = "}])";

    public SyntaxValidator() {}

    public boolean processText(String rawText) {
        if (rawText.isEmpty()) return true;

        Deque<Character> bracketsStack = new ArrayDeque<>();

        for (int i = 0; i < rawText.length(); i++) {
            char symbol = rawText.charAt(i);

            if (leftBrackets.indexOf(symbol) != -1) {
                bracketsStack.addFirst(symbol);
            } else if (rightBrackets.indexOf(symbol) != -1) {
                Character lastBracketFromStack = bracketsStack.pollFirst();

                if (lastBracketFromStack == null ||
                        leftBrackets.indexOf(lastBracketFromStack) != rightBrackets.indexOf(symbol)) {
                    return false;
                }
            }
        }

        return bracketsStack.isEmpty();
    }
}

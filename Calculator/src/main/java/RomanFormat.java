import java.util.*;

public class RomanFormat implements NumberFormat {
    private final int MAX_LENGTH = 7;

    private final Set<Character> accessedChars;
    private final Map<String, Integer> fromRomanToArabic;
    private final Map<Integer, String> fromArabicToRoman;

    public RomanFormat() {
        accessedChars = Set.of('I', 'V', 'X');

        fromRomanToArabic = Map.of("I", 1, "II", 2, "III", 3, "IV", 4, "V", 5,
                "VI", 6, "VII", 7, "VIII", 8, "IX", 9, "X", 10);


        fromArabicToRoman = new HashMap<>();

        for (var entry : fromRomanToArabic.entrySet()) {
            fromArabicToRoman.put(entry.getValue(), entry.getKey());
        }
    }

    public int parse(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Минимальное значение - " + MIN_VALUE);
        }

        int prevValue = 0;
        int value = 0;

        for (int i = text.length() - 1; i >= 0; i--) {
            int currentValue;

            try {
                currentValue = fromRomanToArabic.get(Character.toString(text.charAt(i)));
            } catch (NullPointerException e) {
                throw new IllegalArgumentException("Диапозон значений - [" + format(MIN_VALUE) + ", " +
                        format(MAX_VALUE) + "]");
            }

            if (currentValue < prevValue) {
                value -= currentValue;
            } else {
                value += currentValue;
            }

            prevValue = currentValue;
        }

        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("Диапозон значений - [" + format(MIN_VALUE) + ", " +
                    format(MAX_VALUE) + "]");
        }

        if (!text.equals(format(value))) {
            throw new IllegalArgumentException("Неверный формат римского числа");
        }

        return value;
    }

    public String format(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("Диапозон значений - [" + MIN_VALUE + ", " + MAX_VALUE + "]");
        }

        int tens = number / 10;
        int ones = number % 10;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < tens; i++) {
            result.append(fromArabicToRoman.get(10));
        }

        result.append(fromArabicToRoman.get(ones));

        return result.toString();
    }

    public boolean matches(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }

        if (text.length() > MAX_LENGTH) {
            return false;
        }

        for (int i = 0; i < text.length(); i++) {
            if (!accessedChars.contains(text.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

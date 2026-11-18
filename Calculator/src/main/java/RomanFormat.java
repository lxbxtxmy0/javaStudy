import java.util.*;


final public class RomanFormat implements NumberFormat {
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 39;

    private final Map<String, Integer> fromRomanToArabic;
    private final Map<Integer, String> fromArabicToRoman;

    public RomanFormat() {
        fromRomanToArabic = Map.of("I", 1, "II", 2, "III", 3, "IV", 4, "V", 5,
                "VI", 6, "VII", 7, "VIII", 8, "IX", 9, "X", 10);


        fromArabicToRoman = new HashMap<>();

        for (var entry : fromRomanToArabic.entrySet()) {
            fromArabicToRoman.put(entry.getValue(), entry.getKey());
        }
    }

    @Override
    public int parse(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Нельзя преобразовать пустую строку в число");
        }

        int prevValue = 0;
        int value = 0;

        for (int i = text.length() - 1; i >= 0; i--) {
            Integer currentValue = fromRomanToArabic.get(Character.toString(text.charAt(i)));
            ;

            if (currentValue == null) {
                throw new IllegalArgumentException("Недопустимый символ - " + text.charAt(i) + " в строке " + text);
            }

            if (currentValue < prevValue) {
                value -= currentValue;
            } else {
                value += currentValue;
            }

            prevValue = currentValue;
        }

        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("Римские числа должны быть в диапозоне - ["
                    + format(MIN_VALUE)
                    + ", " + format(MAX_VALUE) + "]");
        }

        if (!text.equals(format(value))) {
            throw new IllegalArgumentException("Неверный формат римского числа");
        }

        return value;
    }

    @Override
    public String format(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("Римские числа должны быть в диапозоне - ["
                    + format(MIN_VALUE)
                    + ", " + format(MAX_VALUE) + "]");
        }

        int tens = number / 10;
        int ones = number % 10;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < tens; i++) {
            result.append(fromArabicToRoman.get(10));
        }

        if (ones != 0) result.append(fromArabicToRoman.get(ones));

        return result.toString();
    }
}

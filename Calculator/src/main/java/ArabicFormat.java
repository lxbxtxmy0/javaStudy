public class ArabicFormat implements NumberFormat{
    public int parse(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Неверный формат арабского числа");
        }

        int result = Integer.parseInt(text);

        if (result < MIN_VALUE || result > MAX_VALUE) {
            throw new IllegalArgumentException("Диапозон значений - [" + MIN_VALUE + ", " + MAX_VALUE + "]");
        }

        return result;
    }

    public String format(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("Диапозон значений - [" + MIN_VALUE + ", " + MAX_VALUE + "]");
        }

        return Integer.toString(number);
    }

    public boolean matches(String text) {
        try {
            parse(text);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}

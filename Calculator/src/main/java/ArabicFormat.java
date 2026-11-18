final public class ArabicFormat implements NumberFormat {
    @Override
    public int parse(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Нельзя преобразовать пустоту в число");
        }

        int start = text.charAt(0) == '-' ? 1 : 0;

        if (start == text.length()) {
            throw new IllegalArgumentException("После минуса нет цифр: " + text);
        }

        for (int i = start; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException("Передано не арабское число: " + text);
            }
        }

        if (text.charAt(start) == '0' && text.length() - start > 1) {
            throw new IllegalArgumentException("Ведущие нули запрещены: " + text);
        }

        if (start == 1 && text.charAt(1) == '0') {
            throw new IllegalArgumentException("«Минус ноль» не допускается: " + text);
        }

        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Число не помещается в int: " + text, e);
        }
    }

    @Override
    public String format(int number) {
        return Integer.toString(number);
    }
}

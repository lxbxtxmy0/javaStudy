public class Calculator {
    private final NumberFormat arabicFormat = new ArabicFormat();
    private final NumberFormat romanFormat = new RomanFormat();

    public String calculate(String operand1, String operator, String operand2) {
        if (arabicFormat.matches(operand1) && arabicFormat.matches(operand2)) {
            return calculate(arabicFormat, operand1, operator, operand2);
        } else if (romanFormat.matches(operand1) && romanFormat.matches(operand2)) {
            return calculate(romanFormat, operand1, operator, operand2);
        } else {
            throw new IllegalArgumentException("Неверно переданы операнды");
        }
    }

    private String calculate(NumberFormat numberFormat, String operand1, String operator, String operand2) {
        return switch (operator) {
            case "+" -> numberFormat.format(numberFormat.parse(operand1) + numberFormat.parse(operand2));
            case "-" -> numberFormat.format(numberFormat.parse(operand1) - numberFormat.parse(operand2));
            case "*" -> numberFormat.format(numberFormat.parse(operand1) * numberFormat.parse(operand2));
            case "/" -> numberFormat.format(numberFormat.parse(operand1) / numberFormat.parse(operand2));
            default -> throw new IllegalArgumentException("Неподдержанный тип оператора");
        };
    }
}

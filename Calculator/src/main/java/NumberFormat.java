public interface NumberFormat {
    int MAX_VALUE = 39;
    int MIN_VALUE = 1;

    boolean matches(String text);
    int parse(String text);
    String format(int number);
}

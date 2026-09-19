public class Main {
    private static char[] fromStringToCharArray(String text) {
        int length = text.length();

        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = text.charAt(i);
        }

        return result;
    }

    private static String fromCharArrayToString(char[] text) {
        int length = text.length;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(text[i]);
        }

        return result.toString();
    }

    public static String coder(String text, int shift) {
        char[] symbols = fromStringToCharArray(text);

        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == ' ' || symbols[i] == ',') {
                continue;
            }
            symbols[i] += shift;
        }

        return fromCharArrayToString(symbols);
    }

    public static String decoder(String text, int shift) {
        char[] symbols = fromStringToCharArray(text);

        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == ' ' || symbols[i] == ',') {
                continue;
            }
            symbols[i] -= shift;
        }

        return fromCharArrayToString(symbols);
    }


    public static void main(String[] args) {
        String mode = args[0];
        String message = args[1];
        int shift = Integer.parseInt(args[2 ]);

        String chiper = "";
        if (mode.equals("code")) {
            chiper = coder(message, shift);
        } else if (mode.equals("decode")) {
            chiper = decoder(message, shift);
        }

        System.out.println(chiper);
    }
}

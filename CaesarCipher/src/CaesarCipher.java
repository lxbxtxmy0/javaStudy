public class CaesarCipher {
    public CaesarCipher() {}

    public String code(String text, int shift) {
        char[] symbols = text.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            if (Character.isLetter(symbols[i])) {
                if ('A' <= symbols[i] && symbols[i] <= 'Z') {
                    symbols[i] = (char) ((symbols[i] - 'A' + (shift % 26) + 26) % 26 + 'A');
                } else if ('a' <= symbols[i] && symbols[i] <= 'z') {
                    symbols[i] = (char) ((symbols[i] - 'a' + (shift % 26) + 26) % 26 + 'a');
                } else if ('А' <= symbols[i] && symbols[i] <= 'Я') {
                    symbols[i] = (char) ((symbols[i] - 'А' + (shift % 32) + 32) % 32 + 'А');
                } else if ('а' <= symbols[i] && symbols[i] <= 'я') {
                    symbols[i] = (char) ((symbols[i] - 'а' + (shift % 32) + 32) % 32 + 'а');
                }
            }
        }

        return new String(symbols);
    }

    public String decode(String text, int shift) {
        char[] symbols = text.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            if (Character.isLetter(symbols[i])) {
                if ('A' <= symbols[i] && symbols[i] <= 'Z') {
                    symbols[i] = (char) ((symbols[i] - 'A' - (shift % 26) + 26) % 26 + 'A');
                } else if ('a' <= symbols[i] && symbols[i] <= 'z') {
                    symbols[i] = (char) ((symbols[i] - 'a' - (shift % 26) + 26) % 26 + 'a');
                } else if ('А' <= symbols[i] && symbols[i] <= 'Я') {
                    symbols[i] = (char) ((symbols[i] - 'А' - (shift % 32) + 32) % 32 + 'А');
                } else if ('а' <= symbols[i] && symbols[i] <= 'я') {
                    symbols[i] = (char) ((symbols[i] - 'а' - (shift % 32) + 32) % 32 + 'а');
                }
            }
        }

        return new String(symbols);
    }
}

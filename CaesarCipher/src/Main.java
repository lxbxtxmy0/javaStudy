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

        return fromCharArrayToString(symbols);
    }

    public static String decoder(String text, int shift) {
        char[] symbols = fromStringToCharArray(text);

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

        return fromCharArrayToString(symbols);
    }

    public static void main(String[] args) {
        // все что ниже касается всех приложений
        // 1 не надо использовать аргумент args в функции main создовай переменную в теле метода
        // 2 добавь описание заданий перед кодом в закомментированном виде иначе я не понимаю что делает код
        // 3 функцию main всегда ставь первой в классе, чтобы я не искал ее а сразу смог запустить
        // 4 начинай сразу писать в ооп стиле (не используй статические методы в одном классе, создавай
        // классы и используй их объекты, main функцию используй только для запуска приложения)
        // 5 я добавил модуль с maven (почитай и изучи? что это такое, если не поймешь пока, то ничего страшного, просто почитай)
        // 6 если с maven разберешься, то посмотри, что такое юнит тесты и как это работает
        // 7 удали из репозетория весь мусор (то что ты добаил в гит игнор, но почему-то в проекте эти папки и файлы есть)
        //

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

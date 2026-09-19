import java.util.Random;

public class Main {
    static char[][] dictionary = {
            "abcdefghijklmnopqrstuvwxyz".toCharArray(),
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(),
            "0123456789".toCharArray(),
            "!@#$%^&*()-_=+".toCharArray()
    };

    public static boolean contains(char symbol, char[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i] == symbol) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCorrectPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialSymbol = false;

        for (int i = 0; i < password.length(); i++) {
            if (contains(password.charAt(i), dictionary[1])) {
                hasUpperCase = true;
            } else if (contains(password.charAt(i), dictionary[0])) {
                hasLowerCase = true;
            } else if (contains(password.charAt(i), dictionary[2])) {
                hasDigit = true;
            } else if (contains(password.charAt(i), dictionary[3])) {
                hasSpecialSymbol = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialSymbol;
    }

    public static String generatePassword(int length) {
        if (length < 8) {
            return null;
        }

        Random random = new Random();

        StringBuilder password = new StringBuilder();

        password.append(dictionary[0][random.nextInt(dictionary[0].length)]);
        password.append(dictionary[1][random.nextInt(dictionary[1].length)]);
        password.append(dictionary[2][random.nextInt(dictionary[2].length)]);
        password.append(dictionary[3][random.nextInt(dictionary[3].length)]);

        for (int i = 0; i < length - 4; i++) {
            int row = random.nextInt(dictionary.length);
            int column = random.nextInt(dictionary[row].length);
            password.append(dictionary[row][column]);
        }
        System.out.println(password.toString());
        for (int i = 0; i < length; i++) {
            char temp = password.charAt(i);
            int randomPosition = random.nextInt(length);
            password.setCharAt(i, password.charAt(randomPosition));
            password.setCharAt(randomPosition, temp);
        }
        System.out.println(password.toString());


        return password.toString();
    }

    public static void main(String[] args) {
        generatePassword(11);
    }
}
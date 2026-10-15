import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dig1 = 0;
        int dig2 = 0;

        if (scanner.hasNextInt()) {
            dig1 = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            dig2 = scanner.nextInt();
        }

        int intSum = dig1 + dig2;
        long longSum = (long) dig1 + dig2;

        System.out.println(intSum);
        System.out.println(longSum);
    }
}
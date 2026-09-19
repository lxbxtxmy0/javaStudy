class Main {
    public static double convertFromCtoF(double degrees) {
        return degrees * 1.8 + 32;
    }

    public static double convertFromFtoC(double degrees) {
        return (degrees - 32) / 1.8;
    }

    public static void main(String[] args) {
        double degrees = Double.parseDouble(args[0]);
        String kindOfDegrees = args[1];

        double result;
        if (kindOfDegrees.equals("C")) {
            result = convertFromCtoF(degrees);
        } else if (kindOfDegrees.equals("F")){
            result = convertFromFtoC(degrees);
        } else {
            System.out.println("Ошибка: введена неизвестная шкала. Используйте C или F.");
            return;
        }

        int truncatedResult = (int) result;

        System.out.println("Точный результат - " + result);
        System.out.println("Усеченный результат - " + truncatedResult);
    }
}
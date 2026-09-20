//Статистический анализатор набора данных
//Цель: Программа для расчета базовой статистики по заранее заданному (или сгенерированному) массиву чисел.

//Ключевые функции: Поиск минимального и максимального значения в массиве, вычисление суммы всех элементов,
// расчет точного среднего арифметического значения. Опционально — реверс массива (перестановка элементов задом наперед).

//Какие новые концепции можно потрогать: Механизмы Autoboxing и Unboxing
// (если создать два массива: примитивный int[] и массив объектов Integer[],
// и попробовать перекладывать данные между ними), безопасное расширение типов
// (почему сумму элементов массива int иногда лучше хранить в long),
// приведение целых чисел к числам с плавающей точкой для корректного деления при поиске среднего.

public class Main {
    public static void main(String[] args) {
        StatisticalAnalyzer tools = new StatisticalAnalyzer();

        Integer[] arr = new Integer[] {20, 1};
        System.out.println(tools.maxEltFromArray(arr));
        System.out.println(tools.minEltFromArray(arr));
        System.out.println(tools.sumEltsFromArray(arr));
        System.out.println(tools.arithmeticMeanOfArray(arr));
    }
}
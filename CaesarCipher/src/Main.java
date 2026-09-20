//Шифратор и дешифратор Цезаря
//Цель: Создать программу, которая берет текстовое сообщение и «сдвигает» каждую букву на определенное количество позиций
// в алфавите, а затем умеет возвращать текст в исходное состояние.

//Ключевые функции: Пользователь задает сдвиг (число) и текст. Программа разбивает текст на массив символов (char[]),
// математически сдвигает каждый символ по таблице Unicode и собирает обратно.
// Должна корректно обрабатывать пробелы и знаки препинания (оставлять их как есть).

//Какие новые концепции можно потрогать: Арифметика символов (например, char c = 'a' + 3), явное и неявное приведение
// типов между int и char, использование статических методов класса Character
// (например, Character.isLetter(), Character.isUpperCase()).

public class Main {
    public static void main(String[] args) {
        CaesarCipher tools = new CaesarCipher();

        String text = "abcd";
        int shift = 15;

        String coded = tools.code(text, shift);
        System.out.println(coded);

        String decoded = tools.decode(coded, shift);
        System.out.println(decoded);
    }
}

public class Main {
    public static void main(String[] args) {
        SpellChecker tools = new SpellChecker();

        tools.handleText("Программа написала код, но там ошибка!" +
                " Компилятор выдал исключение. Яблоко, банан и маштна." +
                " Работает ли цикл? Проверка: собака, кошка, фреймворк..." +
                " Сервер завис, а алогритм сломался.");

        tools.getWords();

    }

}

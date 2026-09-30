//        **Техническое задание: Модуль «Банковский счет»**
//
//        **1. Данные и ограничения сущности**
//
//        * У каждого счета есть строковый идентификатор. Он присваивается в момент создания и не подлежит
//        изменению в дальнейшем.
//        * Счет хранит денежный баланс в формате дробного числа. Баланс физически не может уйти в минус.
//        Изменение баланса напрямую (в обход операций) строго запрещено.
//        * Счет имеет статус блокировки. Любой новый счет изначально активен.
//        * Банк устанавливает единый для всех счетов порог минимального пополнения — `10.0`.
//        * Система должна вести глобальный учет: сколько всего счетов было открыто за время работы программы.
//
//        **2. Создание счета (Инициализация)**
//
//        * **Способ А (Пользовательский):** Открытие счета с передачей конкретного идентификатора и стартового баланса.
//        Если стартовая сумма отрицательная, баланс устанавливается в `0.0`.
//        * **Способ Б (Автоматический):** Открытие счета без передачи данных. Баланс равен `0.0`,
//        а идентификатор генерируется по шаблону `"ACC-" + <порядковый_номер>` (например, `"ACC-1"`, `"ACC-2"`).
//        Этот способ должен переиспользовать логику инициализации из Способа А, а не копировать её.
//
//        **3. Бизнес-операции (Транзакции и доступ)**
//
//        * **Пополнение:** Принимает сумму. Операция проходит, если счет активен и сумма больше или равна
//        установленному банковскому минимуму. Метод обязан возвращать статус (успех или отказ).
//        * **Снятие:** Принимает сумму. Операция проходит, если счет активен, запрашиваемая сумма строго
//        больше нуля и на балансе хватает средств. Метод обязан возвращать статус (успех или отказ).
//        * **Управление:** Внешний код должен иметь возможность заблокировать и разблокировать счет.
//        * **Чтение:** Внешний код может запросить идентификатор, текущий баланс и статус конкретного счета.
//        Также должен быть доступен запрос общего количества открытых счетов в системе.
//
//        **4. Приемочный тест (Класс Main)**
//
//        * Создать два разных счета: один Способом А, другой Способом Б.
//        * Провести успешные транзакции пополнения и снятия.
//        * Провести транзакции, которые должны быть отклонены (пополнение на сумму ниже минимума, попытка снять больше,
//        чем есть на балансе).
//        * Заморозить счет и убедиться, что транзакции больше не проходят.
//        * Вывести на экран итоговые балансы обоих счетов и общее количество счетов в системе.

public class Main {
    public static void main(String[] args) {
        System.out.println("создание счетов:");
        System.out.println("Общее количество счетов: " + BankAccountJava.getAccountsCount());
        BankAccountJava accountA = new BankAccountJava("custom id", 50);
        System.out.println("Общее количество счетов: " + BankAccountJava.getAccountsCount());
        BankAccountJava accountB = new BankAccountJava();
        System.out.println("Общее количество счетов: " + BankAccountJava.getAccountsCount());

        System.out.println(accountA);
        System.out.println(accountB);

        System.out.println("успешные транзакции:");

        System.out.println(accountA.topUpBalance(50));
        System.out.println(accountB.topUpBalance(50));

        System.out.println(accountA);
        System.out.println(accountB);

        System.out.println(accountA.withdrawFromBalance(10));
        System.out.println(accountB.withdrawFromBalance(10));

        System.out.println(accountA);
        System.out.println(accountB);

        System.out.println("неуспешные транзакции:");

        System.out.println(accountA.topUpBalance(5));
        System.out.println(accountB.topUpBalance(5));

        System.out.println(accountA);
        System.out.println(accountB);

        System.out.println(accountA.withdrawFromBalance(-1));
        System.out.println(accountB.withdrawFromBalance(-1));

        System.out.println(accountA);
        System.out.println(accountB);

        System.out.println(accountA.withdrawFromBalance(100));
        System.out.println(accountB.withdrawFromBalance(100));

        System.out.println(accountA);
        System.out.println(accountB);

        System.out.println("заморозка счета:");

        accountA.setActive(false);
        accountB.setActive(false);

        System.out.println(accountA);
        System.out.println(accountB);

        System.out.println(accountA.topUpBalance(10));
        System.out.println(accountB.topUpBalance(10));

        System.out.println(accountA);
        System.out.println(accountB);

        System.out.println(accountA.withdrawFromBalance(10));
        System.out.println(accountB.withdrawFromBalance(10));

        System.out.println(accountA);
        System.out.println(accountB);

        System.out.println("Итог:");
        System.out.println(accountA);
        System.out.println(accountB);
        System.out.println("Общее количество счетов: " + BankAccountJava.getAccountsCount());
    }
}
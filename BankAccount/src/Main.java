//**Техническое задание: Модуль «Банковский счет»**
//
//        **1. Данные и ограничения сущности**
//
//        * У каждого счета есть строковый идентификатор. Он присваивается в момент создания и не подлежит изменению в дальнейшем.
//* Счет хранит денежный баланс в формате дробного числа. Баланс физически не может уйти в минус. Изменение баланса напрямую (в обход операций) строго запрещено.
//        * Счет имеет статус блокировки. Любой новый счет изначально активен.
//* Банк устанавливает единый для всех счетов порог минимального пополнения — `10.0`.
//        * Система должна вести глобальный учет: сколько всего счетов было открыто за время работы программы.
//
//**2. Создание счета (Инициализация)**
//
//        * **Способ А (Пользовательский):** Открытие счета с передачей конкретного идентификатора и стартового баланса. Если стартовая сумма отрицательная, баланс устанавливается в `0.0`.
//        * **Способ Б (Автоматический):** Открытие счета без передачи данных. Баланс равен `0.0`, а идентификатор генерируется по шаблону `"ACC-" + <порядковый_номер>` (например, `"ACC-1"`, `"ACC-2"`). Этот способ должен переиспользовать логику инициализации из Способа А, а не копировать её.
//
//        **3. Бизнес-операции (Транзакции и доступ)**
//
//        * **Пополнение:** Принимает сумму. Операция проходит, если счет активен и сумма больше или равна установленному банковскому минимуму. Метод обязан возвращать статус (успех или отказ).
//        * **Снятие:** Принимает сумму. Операция проходит, если счет активен, запрашиваемая сумма строго больше нуля и на балансе хватает средств. Метод обязан возвращать статус (успех или отказ).
//        * **Управление:** Внешний код должен иметь возможность заблокировать и разблокировать счет.
//* **Чтение:** Внешний код может запросить идентификатор, текущий баланс и статус конкретного счета. Также должен быть доступен запрос общего количества открытых счетов в системе.
//
//**4. Приемочный тест (Класс Main)**
//
//        * Создать два разных счета: один Способом А, другой Способом Б.
//* Провести успешные транзакции пополнения и снятия.
//        * Провести транзакции, которые должны быть отклонены (пополнение на сумму ниже минимума, попытка снять больше, чем есть на балансе).
//        * Заморозить счет и убедиться, что транзакции больше не проходят.
//        * Вывести на экран итоговые балансы обоих счетов и общее количество счетов в системе.

public class Main {
    public static void main(String[] args) {
        BankAccountJava account1 = new BankAccountJava();
        BankAccountJava account2 = new BankAccountJava(52);

        System.out.println(account1.getId());
        System.out.println(account2.getId());

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println(account1.addBalance(52));
        System.out.println(account2.addBalance(52));

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println(account1.subBalance(10));
        System.out.println(account2.subBalance(10));

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println(account1.subBalance(1000));
        System.out.println(account2.subBalance(1000));

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println(account1.addBalance(-100));
        System.out.println(account2.addBalance(-100));

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println(account1.addBalance(5));
        System.out.println(account2.addBalance(6));

        account1.switchStatus();
        account2.switchStatus();

        System.out.println(account1.getStatus());
        System.out.println(account2.getStatus());

        System.out.println(account1.addBalance(52));
        System.out.println(account2.addBalance(52));

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println(account1.subBalance(10));
        System.out.println(account2.subBalance(10));

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        account1.switchStatus();
        account2.switchStatus();

        System.out.println(account1.getStatus());
        System.out.println(account2.getStatus());

        System.out.println(account1.addBalance(52));
        System.out.println(account2.addBalance(52));

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println(account1.subBalance(10));
        System.out.println(account2.subBalance(10));

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println(BankAccountJava.getAccountsCount());
    }
}
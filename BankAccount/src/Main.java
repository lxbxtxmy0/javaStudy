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
public class BankAccountJava {
    public static final double MIN_DEPOSIT = 10.0;

    private static int accountsCount = 0;

    public static int getAccountsCount() {
        return accountsCount;
    }


    private final String id;
    private double balance;
    private boolean active = true;

    public String getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean getStatus() {
        return this.active;
    }

    public BankAccountJava(double balance) {
        this.id = "ACC-" + accountsCount;
        accountsCount += 1;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0.0;
        }
    }

    public BankAccountJava() {
        this(0);
    }

    public boolean addBalance(double amount) {
        if (!this.active || amount < MIN_DEPOSIT) {
            return false;
        }

        this.balance += amount;
        return true;
    }

    public boolean subBalance(double amount) {
        if (!this.active || amount < 0 || this.balance - amount < 0) {
            return false;
        }

        this.balance -= amount;
        return true;
    }

    public void switchStatus() {
        this.active = !this.active;
    }
}
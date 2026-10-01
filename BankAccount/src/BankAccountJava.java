public class BankAccountJava {

    private final double MIN_DEPOSIT = 10.0;

    private static int accountsCount;

    private final String id;
    private double balance;
    private boolean active;

    public BankAccountJava(String id, double balance) {
        this.id = id;
        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0.0;
        }
        this.active = true;
        accountsCount += 1;
    }

    public BankAccountJava() {
        this("ACC-" + (accountsCount + 1), 0);
    }
sfsdfsdf
    public static int getAccountsCount() {
        return accountsCount;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean topUpBalance(double amount) {
        if (isActive() && amount >= MIN_DEPOSIT) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdrawFromBalance(double amount) {
        if (isActive() && amount > 0 && balance - amount >= 0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccountJava{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", active=" + active +
                '}';
    }
}
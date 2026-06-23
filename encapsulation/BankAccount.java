public class BankAccount {
    private double balance; // hidden from outside

    // getter - read the value safely
    public double getBalance() {
        return balance;
    }

    // setter with a check - control how it changes
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }
}

package Task1;

public class BankAccount {
    //Variables to store balance and account number and to keep track of how many accounts there are.
    private static int totalAccounts = 0;
    private final int accountNumber;
    private double balance;

    //Simple constructor to give wanted balance and identifiable bank account by number.
    BankAccount (double balance) {
        this.balance = balance;
        this.accountNumber = totalAccounts++ + 1;
    }

    //Getters.
    public double getBalance() { return balance; }
    public int getAccountNumber() { return accountNumber; }
    public static int getTotalAccounts() { return totalAccounts; }

    //methods to change balance with given value if possible
    public void deposit(double amount) { this.balance += amount; }
    public void withdraw(double amount) {
        if( this.balance - amount > 0){
            this.balance -= amount;
        }
        else {
            System.out.println("Insufficient Balance!");
        }
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
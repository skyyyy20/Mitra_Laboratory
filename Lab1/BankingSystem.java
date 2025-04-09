// Base class: Bank Account
class BankAccount {
    private String accountHolderName;
    private double balance;
 
    // Constructor
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }
 
    // Encapsulation: Getter and Setter methods
    public String getAccountHolderName() {
        return accountHolderName;
    }
 
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
 
    public double getBalance() {
        return balance;
    }
 
    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
 
    // Method for withdrawal of money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance");
        }
    }
 
    // Polymorphism: Method Overriding
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}
 
// Derived class: SavingsAccount extends BankAccount
class SavingsAccount extends BankAccount {
    private double interestRate;
 
    // Constructor
    public SavingsAccount(String accountHolderName, double initialBalance, double interestRate) {
        super(accountHolderName, initialBalance);
        this.interestRate = interestRate;
    }
 
    // Overriding displayAccountDetails method
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate);
    }
 
    // Method to calculate interest
    public void calculateInterest() {
        double interest = getBalance() * interestRate;
        System.out.println("Interest: " + interest);
    }
}
 
// Derived class: CurrentAccount extends BankAccount
class CurrentAccount extends BankAccount {
    private double overdraftLimit;
 
    // Constructor
    public CurrentAccount(String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }
 
    // Overriding withdraw method to include overdraft limit
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            double newBalance = getBalance() - amount;
            if (newBalance < 0) {
                overdraftLimit += newBalance; // Reduce overdraft limit
            }
            super.withdraw(amount); // Adjust balance
        } else {
            System.out.println("Invalid withdrawal amount or overdraft limit exceeded");
        }
    }
 
    // Overriding displayAccountDetails method
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}
 
// Main class
public class BankingSystem {
    public static void main(String[] args) {
        // Create a SavingsAccount
        SavingsAccount savings = new SavingsAccount("Ashley", 1000, 0.05);
        savings.displayAccountDetails();
        savings.withdraw(300);
        savings.displayAccountDetails();
 
        System.out.println();
 
        // Create a CurrentAccount
        CurrentAccount current = new CurrentAccount("Mitra", 2000, 1000);
        current.displayAccountDetails();
        current.withdraw(2500);
        current.withdraw(500);
        current.displayAccountDetails();
    }
}
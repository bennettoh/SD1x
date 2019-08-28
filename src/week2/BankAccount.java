package week2;

public class BankAccount {
    double balance;
    String accountOwner;
    
    public BankAccount (String owner) {
	balance = 27;
	accountOwner = owner;
    }
    
    //deposit
    public void deposit(double amount) {
	balance += amount;
    }
    
    //withdraw
    public void withdraw (double amount) {
	balance -= amount;
    }
    
    public boolean equals(Object o) {
	return (((BankAccount) o).accountOwner).equals(accountOwner);
    }

}

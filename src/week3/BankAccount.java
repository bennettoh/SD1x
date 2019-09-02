package week3;

public class BankAccount {
    double balance;    
    //customer to whom this bank account belongs
    Customer customer;
    //counts the number of account made. Shared across all instances
    static int counter = 10000;
    //instance variable of account number
    int accountNumber;
    
    BankAccount(String name, int age){
	balance = 0;
	customer = new Customer (name, age);
	counter++;
	accountNumber = counter;
    }
    
    public static void main(String[] args) {
	BankAccount a1 = new BankAccount("x", 35);
	BankAccount a2 = new BankAccount("abc", 16);
	
	System.out.println(a1.accountNumber + " " + a1.customer.name);
	System.out.println(a2.accountNumber + " " + a2.customer.name);
	}

}

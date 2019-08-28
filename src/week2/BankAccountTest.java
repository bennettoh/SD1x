package week2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {
    BankAccount account;

    @BeforeEach
    void setUp() throws Exception {
	account = new BankAccount("default");
    }

    @Test
    void testDeposit() {
	assertEquals(27, account.balance);
	account.deposit(1);
	assertEquals(28, account.balance);
    }

    @Test
    void testOwner1() {
	assertEquals(account, new BankAccount("default"));
    }
    
    @Test
    void testOwner2() {
	assertTrue(account == new BankAccount("default"));
    }
    
    @Test
    void testOnwer3() {
	assertTrue(account.equals(new BankAccount("default")));
    }
}

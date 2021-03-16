package javabd.labs.h7_objectorientation.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankTest {

    private Bank b;

    @BeforeEach // @Before
    void setUp() {
        b = new Bank();
        b.addAccount(new BankAccount(1));
        b.addAccount(new BankAccount(2));
    }

    @Test
    void whenAccountsToStringThenItContainsAllAccountsInfoAndTotalAmount() {
        // given

        // when
        String accountsInfo = b.accountsToString();

        // then
        assertNotNull(accountsInfo);
        assertTrue(accountsInfo.contains("Account 1 has balance: 0"));
        assertTrue(accountsInfo.contains("Account 2 has balance: 0"));
        assertTrue(accountsInfo.contains("Total is: 0"));
    }
}

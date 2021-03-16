package javabd.labs.h7_objectorientation.bank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private BankAccount testAccount;

    @Before // annotatie
    public void setup() {
        testAccount = new BankAccount(123);
        testAccount.deposit(100);
    }

    @Test
    public void whenWithdrawThenSubtractedFromBalance() {
        // given: see setup

        // when
        testAccount.withdraw(30);

        // then
        assertEquals(70, testAccount.getBalance());
    }

    @Test
    public void whenWithdrawTooMuchThenNotSubtractedFromBalance() {
        // given: see setup

        // when
        testAccount.withdraw(130);

        // then
        assertEquals(100, testAccount.getBalance());
    }

    @Test
    public void whenDepositBalanceIsUpdated() {
        // given: see setup

        // when
        int balanceBefore = testAccount.getBalance();
        testAccount.deposit(300);
        int balanceAfter = testAccount.getBalance();

        assertEquals(300, balanceAfter - balanceBefore);
    }

    @Test
    public void whenGetInterestAfterOneYearThenInterestIsCorrect() {
        // given: see setup
        testAccount.setInterestRate(5);

        // when
        double balance = testAccount.getInterest(1);

        // then
        assertEquals(105, balance, 0);
    }

    @Test
    public void whenGetInterestAfterTenYearsThenBalanceIsCorrect() {
        // given: see setup
        testAccount.setInterestRate(5);

        // when
        double balance = testAccount.getInterest(10);

        // then
        assertEquals(16289, Math.round(balance * 100), 0);
    }
}

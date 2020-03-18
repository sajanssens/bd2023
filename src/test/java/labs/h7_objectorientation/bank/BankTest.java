package labs.h7_objectorientation.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class BankTest {

    private Bank b;
    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    void setUp() {
        b = new Bank();

        account1 = new BankAccount(1);
        account2 = new BankAccount(2);
        b.addAccount(account1);
        b.addAccount(account2);
    }

    @Test
    void testBank() {
        account1.deposit(100);
        account1.deposit(200);
        assertThat(account1.getBalance(), is(300));

        account2.deposit(300);
        account2.deposit(100);
        assertThat(account2.getBalance(), is(400));

        b.printAccounts();
        b.transfer(account1, account2, 100);
        b.printAccounts();
        assertThat(account1.getBalance(), is(200));
        assertThat(account2.getBalance(), is(500));
        assertThat(b.getTotal(), is(700L));

        withDraw(account1, 300);
        assertThat(account1.getBalance(), is(200));
        assertThat(b.getTotal(), is(700L));

        withDraw(account2, 100);
        assertThat(account2.getBalance(), is(400));
        assertThat(b.getTotal(), is(600L));

        b.transfer(account1, account2, 300);
        b.printAccounts();
        assertThat(account1.getBalance(), is(200));
        assertThat(account2.getBalance(), is(400));
        assertThat(b.getTotal(), is(600L));

        account1.setInterestRate(3.00d);
        double interest = account1.getInterest(1);
        assertThat(interest, is(206d));

        account1.setInterestRate(3.87d);
        interest = account1.getInterest(1);
        // assertThat(interest, is(207.74d)); // wont work with primitive double!! (afronding)
    }

    private void withDraw(BankAccount bankAccount, int amount) {
        int withdraw = bankAccount.withdraw(amount);
        System.out.println("Result of withdrawal: " + withdraw);
        System.out.println(bankAccount);
        System.out.println();

    }
}

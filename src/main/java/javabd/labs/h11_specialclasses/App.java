package javabd.labs.h11_specialclasses;

public class App {

    public static void main(String[] args) {
        Bank b = new Bank();

        Bank.BankAccount account1 = b.createAccount(Bank.AccountType.checking);
        Bank.BankAccount account2 = b.createAccount(Bank.AccountType.saving);
        b.addAccount(account1);
        b.addAccount(account2);

        account1.deposit(100);
        account1.deposit(200);
        account2.deposit(300);
        account2.deposit(100);

        b.printAccounts();
        b.transfer(account1.getAccountNumber(), account2.getAccountNumber(), 100);
        b.printAccounts();
    }
}

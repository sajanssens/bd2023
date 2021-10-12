package javabd.labs.h11_specialclasses;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> accounts = new ArrayList<>();
    private long id = 10L;

    public Bank() { }

    public enum AccountType {checking, saving}

    public BankAccount createAccount(AccountType accountType) {
        switch (accountType) {
            case checking:
                return new CheckingAccount(id++);
            case saving:
                return new SavingAccount(id++);
            default:
                return null;
        }
    }

    public void addAccount(BankAccount a) {
        this.accounts.add(a);
    }

    public void transfer(long from, long to, int amount) {
        BankAccount fromAccount = search(from);
        BankAccount toAccount = search(to);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public BankAccount search(long id) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == id) return account;
        }
        throw new IllegalArgumentException("Account not found");
    }

    public void printAccounts(){
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }

    abstract class BankAccount {
        private long accountNumber;
        private int balance;

        public BankAccount(long id) {
            this.accountNumber = id;
        }

        public long getAccountNumber() {
            return accountNumber;
        }

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            this.balance -= amount;
        }

        public void deposit(int amount) {
            this.balance += amount;
        }

        @Override
        public String toString() {
            return "Account " + accountNumber + " has balance: " + balance  ;
        }
    }

    private class CheckingAccount extends BankAccount {
        private CheckingAccount(long id) {
            super(id);
        }
    }

    private class SavingAccount extends BankAccount {
        private float interestRate;
        private SavingAccount(long id) {
            super(id);
        }
    }
}

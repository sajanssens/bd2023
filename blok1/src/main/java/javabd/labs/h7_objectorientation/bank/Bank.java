package javabd.labs.h7_objectorientation.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> accounts = new ArrayList<>();
    private long id = 10L;
    private String name;

    public Bank() {

    }

    public Bank(String eenName) {
        this.name = eenName;
    }

    public BankAccount search(long nr) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == nr) {
                return account;
            }
        }

        throw new AccountNotFoundException("Account met nummer " + nr + " is niet gevonden!");
    }

    public void addAccount(BankAccount a) {
        this.accounts.add(a);
    }

    public void transfer(BankAccount from, BankAccount to, int amount) {
        if (from.withdraw(amount) > 0) {
            to.deposit(amount);
        }
    }

    public String accountsToString() {
        StringBuilder sb = new StringBuilder();

        for (BankAccount account : accounts) {
            sb.append(account).append("\n");
        }
        sb.append("Total is: ");
        sb.append(getTotal());
        sb.append("\n");
        sb.append("\n");

        return sb.toString();
    }

    public long getTotal() {
        long total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

}

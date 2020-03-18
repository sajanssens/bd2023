package labs.h7_objectorientation.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> accounts = new ArrayList<>();
    private long id = 10L;

    public Bank() {
    }

    public void addAccount(BankAccount a) {
        this.accounts.add(a);
    }

    public void transfer(BankAccount from, BankAccount to, int amount) {
        if (from.withdraw(amount) > 0) {
            to.deposit(amount);
        }
    }

    public void printAccounts() {
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
        System.out.println("Total is: " + getTotal());
        System.out.println();
    }

    public long getTotal(){
        long total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }


}
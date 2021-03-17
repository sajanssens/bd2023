package javabd.labs.h7_objectorientation.bank;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String msg) {
        super(msg);
    }

}

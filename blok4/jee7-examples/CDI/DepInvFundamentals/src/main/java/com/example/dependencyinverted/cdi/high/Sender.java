package com.example.dependencyinverted.cdi.high;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static java.util.stream.Collectors.joining;

// High level module
@Dependent
public class Sender {

    // Satisfies:
    // 1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
    private final List<Sendable> sendables = new ArrayList<>();

    // Dependency Injection -----------------------------

    // 1. field injection
    // - Exactly one Sender bean
    // @Inject /*@EM*/  /*@Named("Email")*/
    private Sendable sendable;

    // - All known Sender beans
    @Inject @Any
    private Instance<Sendable> allSenders;

    // 2. constructor injection
    @Inject
    public Sender(/*@EM*/ Sendable s) { addSendable(s); }

    // 3. setter/property injection
    @Inject @Any
    public void setSendable(/*@EM*/ Sendable s) { addSendable(s); }

    public void addSendable(Sendable s) {
        // Satisfies:
        // 2. Abstractions should not depend on details. Details should depend on abstractions.

        // Inversion of control: new is gone. Let someone else supply the object(s)
        sendables.add(s);
    }

    public String sendAll() {
        return sendables.stream()
                .map(Sendable::send)
                .collect(joining(", "));
    }

    public String sendAllBeans() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Sendable sender : allSenders) {
            String sent = sender.send();
            joiner.add(sent);
        }
        return joiner.toString();
    }

    public <S extends Sendable> String send(Class<S> sendable) {
        return sendables.stream()
                .filter(s -> s.getClass().equals(sendable))
                .map(Sendable::send)
                .collect(joining(", "));
    }

}

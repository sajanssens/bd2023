package com.example.dependencyinverted.cdi.low;

import com.example.dependencyinverted.cdi.high.Sendable;
import com.example.dependencyinverted.cdi.util.EM;

import javax.enterprise.inject.Default;

@EM @Default
public class Email implements Sendable {

    private String run() {
        System.out.println("sending email.....");
        // ....
        return "Email is sent!";
    }

    @Override
    public String send() {
        return run();
    }
}

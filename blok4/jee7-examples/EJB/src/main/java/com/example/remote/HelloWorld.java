package com.example.remote;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {
    String getHelloWorld();
}

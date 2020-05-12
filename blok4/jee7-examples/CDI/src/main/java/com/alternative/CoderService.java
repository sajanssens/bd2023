package com.alternative;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CoderService {

    @Inject
    private Coder coder;

    public String letTheCoderWork() {
        return coder.code();
    }
}

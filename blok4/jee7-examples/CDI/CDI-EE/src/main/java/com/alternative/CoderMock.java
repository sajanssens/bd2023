package com.alternative;

import javax.enterprise.inject.Alternative;

@Alternative
public class CoderMock implements Coder{
    @Override
    public String code() {
        return "I mock and I mock...";
    }
}

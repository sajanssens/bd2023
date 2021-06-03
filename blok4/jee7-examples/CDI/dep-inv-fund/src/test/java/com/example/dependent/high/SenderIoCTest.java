package com.example.dependent.high;

import com.example.dependent.low.Email;
import com.example.dependent.low.Sms;
import org.junit.jupiter.api.Test;

import static com.example.dependencyinverted.cdi.util.Util.OK;
import static org.assertj.core.api.Assertions.assertThat;

class SenderIoCTest {

    SenderIoC target = new SenderIoC();

    @Test
    void sendAll() {
        // given
        target.setEmail(new Email());
        target.setSms(new Sms());

        // when
        String s = target.sendAll();

        // then
        assertThat(s).contains(OK);
    }

}

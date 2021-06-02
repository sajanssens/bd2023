package com.example.cdi.observer;

import org.slf4j.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class Bedrijf {

    @Inject Logger log;

    public void onNieuwsbrief(@Observes Nieuwsbrief n) {
        log.info("Nieuwe nieuwsbrief ontvangen! Inhoud: " + n.inhoud);
    }

}

package com.thoughtworks.aceleradora.airline.visao;

import org.springframework.stereotype.Component;

@Component
public class Formatadores {

    private FormatadorVoo voo;

    public Formatadores(FormatadorVoo voo) {
        this.voo = voo;
    }

    public FormatadorVoo getVoo() {
        return voo;
    }

}

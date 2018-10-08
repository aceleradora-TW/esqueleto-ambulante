package com.thoughtworks.aceleradora.airline;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BuscaControllerTest {

    @Test
    public void renderizaCaixaDeBusca() {
        String resultado = new BuscaController().caixaDeBusca();

        assertThat(resultado, equalTo("airline/busca"));
    }
}
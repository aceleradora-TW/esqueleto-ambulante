package com.thoughtworks.aceleradora.mapeadores;

import com.thoughtworks.aceleradora.dominio.FormularioPessoa;
import com.thoughtworks.aceleradora.dominio.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class MapeadorPessoa {

    private ValidadorPessoa validador;

    public Pessoa mapear(FormularioPessoa formulario) {

        return new Pessoa(
                formulario.getNome(),
                formulario.getSobrenome()
        );
    }
}

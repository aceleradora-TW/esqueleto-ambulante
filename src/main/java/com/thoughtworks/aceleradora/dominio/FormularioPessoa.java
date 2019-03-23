package com.thoughtworks.aceleradora.dominio;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FormularioPessoa {

    private String nome;

    private String sobrenome;

    public FormularioPessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}

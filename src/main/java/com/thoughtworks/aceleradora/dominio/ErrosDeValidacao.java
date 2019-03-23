package com.thoughtworks.aceleradora.dominio;

import java.util.HashMap;
import java.util.Map;

public class ErrosDeValidacao {

    private Map<String, String> erros = new HashMap<>();

    public void adicionaErro(String codigo, String mensagem) {
        erros.put(codigo, mensagem);
    }

    public String getMensagem(String codigo) {
        return erros.getOrDefault(codigo, "");
    }

    public boolean possuiErros() {
        return !erros.isEmpty();
    }

}

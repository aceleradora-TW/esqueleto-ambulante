package com.thoughtworks.aceleradora.mapeadores;

import com.thoughtworks.aceleradora.dominio.ErrosDeValidacao;
import com.thoughtworks.aceleradora.dominio.FormularioPessoa;

public class ValidadorPessoa {

    public ErrosDeValidacao validar(FormularioPessoa formularioPessoa) {
        ErrosDeValidacao erros = new ErrosDeValidacao();

        if (formularioPessoa.getNome().isEmpty()) {
            erros.adicionaErro("nome_vazio", "Nome nao pode ser vazio");
        }

        if (formularioPessoa.getSobrenome().isEmpty()) {
            erros.adicionaErro("sobrenome_vazio", "Sobrenome nao pode ser vazio");
        }

        return erros;
    }
}

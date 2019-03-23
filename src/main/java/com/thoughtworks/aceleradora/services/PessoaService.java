package com.thoughtworks.aceleradora.services;

import com.thoughtworks.aceleradora.dominio.FormularioPessoa;
import com.thoughtworks.aceleradora.dominio.Pessoa;
import com.thoughtworks.aceleradora.dominio.PessoaRepository;
import com.thoughtworks.aceleradora.mapeadores.MapeadorPessoa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    private MapeadorPessoa mapeador;

    public PessoaService(PessoaRepository pessoaRepository, MapeadorPessoa mapeador) {
        this.pessoaRepository = pessoaRepository;
        this.mapeador = mapeador;
    }

    public Pessoa salvar(FormularioPessoa formulario) {
        Pessoa pessoa = mapeador.mapear(formulario);

        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> buscarTodos() {
        return null;
    }
}

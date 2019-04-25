package com.thoughtworks.aceleradora.webservice;

import com.thoughtworks.aceleradora.dominio.Pessoa;
import com.thoughtworks.aceleradora.dominio.PessoaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/pessoas")
public class PessoaControllerWs {


    private PessoaRepository repositorio;

    public PessoaControllerWs(PessoaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @ResponseBody
    @GetMapping("/")
    List<Pessoa> all() {
        return (List<Pessoa>) repositorio.findAll();
    }
}

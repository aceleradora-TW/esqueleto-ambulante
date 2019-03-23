package com.thoughtworks.aceleradora.controllers;

import com.thoughtworks.aceleradora.dominio.FormularioPessoa;
import com.thoughtworks.aceleradora.services.PessoaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/cadastro")
    public String formularioCadastro(Model model) {
        FormularioPessoa formulario = new FormularioPessoa();

        model.addAttribute("pessoa", formulario);

        return "pessoa/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvaCadastro(FormularioPessoa formulario) {
        pessoaService.salvar(formulario);

        return "redirect:lista";
    }

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("pessoas", pessoaService.buscarTodos());

        return "pessoa/lista";
    }

}

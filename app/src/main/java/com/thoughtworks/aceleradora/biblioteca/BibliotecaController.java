package com.thoughtworks.aceleradora.biblioteca;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BibliotecaController {

    @GetMapping("/")
    public String listaDeLivros() {
       return "livros/lista";
    }

}

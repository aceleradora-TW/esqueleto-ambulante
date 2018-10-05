package com.thoughtworks.aceleradora.airline;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/airline")
public class BuscaController {

    @GetMapping("/busca")
    public String caixaDeBusca() {
        return "airline/busca";
    }

}

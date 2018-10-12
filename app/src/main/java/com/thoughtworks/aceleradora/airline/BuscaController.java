package com.thoughtworks.aceleradora.airline;

import com.thoughtworks.aceleradora.airline.dominio.Busca;
import com.thoughtworks.aceleradora.airline.dominio.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/airline")
public class BuscaController {

    private VooRepository vooRepository;

    @Autowired
    public BuscaController(VooRepository vooRepository) {
        this.vooRepository = vooRepository;
    }

    @GetMapping("/busca")
    public String caixaDeBusca() {
        return "airline/busca/caixaDeBusca";
    }

    @PostMapping("/busca")
    public String busca(Busca busca, Model model) {

        model.addAttribute("busca", busca);
        model.addAttribute("voos", vooRepository.findAll());

        return "airline/busca/resultado";
    }
}

package com.thoughtworks.aceleradora.airline;

import com.thoughtworks.aceleradora.airline.dominio.Busca;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

@Controller
@RequestMapping("/airline")
public class BuscaController {

    @GetMapping("/busca")
    public String caixaDeBusca() {
        return "airline/busca";
    }

    @PostMapping("/busca")
    @ResponseBody
    public String busca(Busca busca) {
        return busca.toString();
    }
}

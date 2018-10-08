package com.thoughtworks.aceleradora.airline;

import com.thoughtworks.aceleradora.airline.dominio.Aeroporto;
import com.thoughtworks.aceleradora.airline.dominio.Busca;
import com.thoughtworks.aceleradora.airline.dominio.Itinerario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.thoughtworks.aceleradora.airline.ItinerarioRepository.CriteriosDeBusca.porOrigemDestino;

@Controller
@RequestMapping("/airline")
public class BuscaController {

    private ItinerarioRepository repositorioItinerario;

    @Autowired
    public BuscaController(ItinerarioRepository repositorioItinerario) {
        this.repositorioItinerario = repositorioItinerario;
    }

    @GetMapping("/busca")
    public String caixaDeBusca() {

        if (repositorioItinerario.count() == 0) {

            Aeroporto poa = new Aeroporto();
            Aeroporto mia = new Aeroporto();

            poa.setIata("POA");
            poa.setCidade("Porto Alegre");
            poa.setNome("Aeroporto Internacional Salgado Filho");

            mia.setIata("MIA");
            mia.setCidade("Miami");
            mia.setNome("Miami International Airport");

            Itinerario itinerario = new Itinerario();

            itinerario.setOrigem(poa);
            itinerario.setDestino(mia);

            repositorioItinerario.save(itinerario);
        }

        return "airline/busca";
    }

    @PostMapping("/busca")
    public String busca(Busca busca, Model model) {

        List<Itinerario> itinerariosEncontrados = repositorioItinerario
                .findAll(porOrigemDestino(busca.getOrigem(), busca.getDestino()));

        model.addAttribute("itinerarios", itinerariosEncontrados);

        return "airline/resultadoBusca";
    }
}

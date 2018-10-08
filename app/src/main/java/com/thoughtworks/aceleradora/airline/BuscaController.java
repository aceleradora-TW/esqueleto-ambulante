package com.thoughtworks.aceleradora.airline;

import com.thoughtworks.aceleradora.airline.dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

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

        if (vooRepository.count() == 0) {

            Aeroporto poa = new Aeroporto();
            Aeroporto mia = new Aeroporto();
            Aeroporto gru = new Aeroporto();

            poa.setIata("POA");
            poa.setCidade("Porto Alegre");
            poa.setNome("Aeroporto Internacional Salgado Filho");

            mia.setIata("MIA");
            mia.setCidade("Miami");
            mia.setNome("Miami International Airport");

            gru.setIata("GRU");
            gru.setCidade("Sao Paulo");
            gru.setNome("Aeroporto Internacional de Guarulhos");

            Itinerario poaMia = new Itinerario();

            poaMia.setOrigem(poa);
            poaMia.setDestino(mia);
            poaMia.setHorarioDecolagem(LocalDateTime.now());
            poaMia.setHorarioPouso(LocalDateTime.now().plusHours(16));

            Itinerario poaGru = new Itinerario();

            poaGru.setOrigem(poa);
            poaMia.setDestino(gru);
            poaGru.setHorarioDecolagem(LocalDateTime.now());
            poaGru.setHorarioPouso(LocalDateTime.now().plusHours(2));

            Itinerario gruMia = new Itinerario();

            gruMia.setOrigem(gru);
            gruMia.setDestino(mia);
            gruMia.setHorarioDecolagem(LocalDateTime.now().plusHours(5));
            gruMia.setHorarioPouso(LocalDateTime.now().plusHours(16));

            Segmento segPoaGru = new Segmento();
            segPoaGru.setItinerario(poaGru);

            Segmento segGruMia = new Segmento();
            segGruMia.setItinerario(gruMia);

            Voo voo = new Voo();

            voo.setItinerario(poaMia);
            voo.addSegmento(segPoaGru);
            voo.addSegmento(segGruMia);

            vooRepository.save(voo);

        }

        return "airline/busca";
    }

    @PostMapping("/busca")
    public String busca(Busca busca, Model model) {

        model.addAttribute("busca", busca);
        model.addAttribute("voos", vooRepository.findAll());

        return "airline/resultadoBusca";
    }
}

package com.thoughtworks.aceleradora.airline.visao;

import com.thoughtworks.aceleradora.airline.dominio.Aeroporto;
import com.thoughtworks.aceleradora.airline.dominio.Segmento;
import com.thoughtworks.aceleradora.airline.dominio.Voo;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Component
public class FormatadorVoo {

    public List<Aeroporto> percurso(Voo voo) {
        return voo.getSegmentos()
                .stream()
                .map(Segmento::getItinerario)
                .map(itinerarioSegmento -> Stream.of(
                        itinerarioSegmento.getOrigem(),
                        itinerarioSegmento.getDestino()))
                .reduce(Stream::concat)
                .map(paradas -> paradas
                        .distinct()
                        .collect(toList()))
                .orElse(emptyList());
    }

    public int quantidadeParadas(Voo voo) {
        return voo.getSegmentos().size() - 1;
    }

    public long duracaoEmHoras(Voo voo) {
        Duration duracao = Duration.between(
                voo.getItinerario().getHorarioDecolagem(),
                voo.getItinerario().getHorarioPouso()
        );

        return duracao.toHours();
    }
}

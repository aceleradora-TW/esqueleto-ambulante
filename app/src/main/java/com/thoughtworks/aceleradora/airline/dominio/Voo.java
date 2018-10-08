package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Voo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Itinerario itinerario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "voo_segmento",
            joinColumns = @JoinColumn(name = "voo_id"),
            inverseJoinColumns = @JoinColumn(name = "segmento_id"))
    private List<Segmento> segmentos = new ArrayList<>();

    public Voo() {
    }

    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    public List<Segmento> getSegmentos() {
        return segmentos;
    }

    public void setSegmentos(List<Segmento> segmentos) {
        this.segmentos = segmentos;
    }

    public int getParadas() {
        return segmentos.size() - 1;
    }

    public int getDuracaoEmHoras() {
        return (int) Duration.between(itinerario.getHorarioDecolagem(), itinerario.getHorarioPouso()).getSeconds() / 3600;
    }

    public void addSegmento(Segmento segmento) {
        segmentos.add(segmento);
    }
}

package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Voo(Itinerario itinerario, List<Segmento> segmentos) {
        this.itinerario = itinerario;
        this.segmentos = segmentos;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voo voo = (Voo) o;
        return Objects.equals(id, voo.id) &&
                Objects.equals(itinerario, voo.itinerario) &&
                Objects.equals(segmentos, voo.segmentos);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, itinerario, segmentos);
    }

    @Override
    public String toString() {
        return "Voo{" +
                "id=" + id +
                ", itinerario=" + itinerario +
                ", segmentos=" + segmentos +
                '}';
    }
}

package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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

package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Segmento {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Itinerario itinerario;

    public Segmento() {
    }

    public Segmento(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    public Aeroporto getOrigem() {
        return itinerario.getOrigem();
    }

    public Aeroporto getDestino() {
        return itinerario.getDestino();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segmento segmento = (Segmento) o;
        return Objects.equals(id, segmento.id) &&
                Objects.equals(itinerario, segmento.itinerario);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, itinerario);
    }

    @Override
    public String toString() {
        return "Segmento{" +
                "id=" + id +
                ", itinerario=" + itinerario +
                '}';
    }
}

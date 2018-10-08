package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.*;

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
}

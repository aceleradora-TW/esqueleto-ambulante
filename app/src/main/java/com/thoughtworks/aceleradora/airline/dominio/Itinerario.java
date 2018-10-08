package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Itinerario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "origem_aeroporto_id")
    private Aeroporto origem;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "destino_aeroporto_id")
    private Aeroporto destino;

    public Itinerario() {
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }
}

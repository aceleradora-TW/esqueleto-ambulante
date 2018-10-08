package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Segmento {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne
    private Itinerario itinerario;

    private LocalDateTime horarioDecolagem;
    private LocalDateTime horarioPouso;

    public Segmento() {
    }

    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    public LocalDateTime getHorarioDecolagem() {
        return horarioDecolagem;
    }

    public void setHorarioDecolagem(LocalDateTime horarioDecolagem) {
        this.horarioDecolagem = horarioDecolagem;
    }

    public LocalDateTime getHorarioPouso() {
        return horarioPouso;
    }

    public void setHorarioPouso(LocalDateTime horarioPouso) {
        this.horarioPouso = horarioPouso;
    }

    public Aeroporto getOrigem() {
        return itinerario.getOrigem();
    }

    public Aeroporto getDestino() {
        return itinerario.getDestino();
    }
}

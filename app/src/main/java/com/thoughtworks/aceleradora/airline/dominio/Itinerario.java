package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.*;

import java.time.LocalDateTime;

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

    @Column(name = "horario_decolagem")
    private LocalDateTime horarioDecolagem;

    @Column(name = "horario_pouso")
    private LocalDateTime horarioPouso;

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
}

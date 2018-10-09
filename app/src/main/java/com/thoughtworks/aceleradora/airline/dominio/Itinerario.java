package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public Itinerario(Aeroporto origem, Aeroporto destino, LocalDateTime horarioDecolagem, LocalDateTime horarioPouso) {
        this.origem = origem;
        this.destino = destino;
        this.horarioDecolagem = horarioDecolagem;
        this.horarioPouso = horarioPouso;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Itinerario that = (Itinerario) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(origem, that.origem) &&
                Objects.equals(destino, that.destino) &&
                Objects.equals(horarioDecolagem, that.horarioDecolagem) &&
                Objects.equals(horarioPouso, that.horarioPouso);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, origem, destino, horarioDecolagem, horarioPouso);
    }

    @Override
    public String toString() {
        return "Itinerario{" +
                "id=" + id +
                ", origem=" + origem +
                ", destino=" + destino +
                ", horarioDecolagem=" + horarioDecolagem +
                ", horarioPouso=" + horarioPouso +
                '}';
    }
}

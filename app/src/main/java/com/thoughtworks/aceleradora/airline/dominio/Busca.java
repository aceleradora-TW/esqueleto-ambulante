package com.thoughtworks.aceleradora.airline.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Busca {

    private String origem;
    private String destino;
    private int adultos;
    private LocalDate dataIda;
    private LocalDate dataVolta;

    public Busca() {
    }

    public Busca(String origem, String destino, int adultos, LocalDate dataIda, LocalDate dataVolta) {
        this.origem = origem;
        this.destino = destino;
        this.adultos = adultos;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getAdultos() {
        return adultos;
    }

    public void setAdultos(int adultos) {
        this.adultos = adultos;
    }

    public LocalDate getDataIda() {
        return dataIda;
    }

    public void setDataIda(LocalDate dataIda) {
        this.dataIda = dataIda;
    }

    public LocalDate getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(LocalDate dataVolta) {
        this.dataVolta = dataVolta;
    }

    @Override
    public String toString() {
        return "Busca{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", adultos=" + adultos +
                ", dataIda=" + dataIda +
                ", dataVolta=" + dataVolta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Busca busca = (Busca) o;
        return adultos == busca.adultos &&
                Objects.equals(origem, busca.origem) &&
                Objects.equals(destino, busca.destino) &&
                Objects.equals(dataIda, busca.dataIda) &&
                Objects.equals(dataVolta, busca.dataVolta);
    }

    @Override
    public int hashCode() {

        return Objects.hash(origem, destino, adultos, dataIda, dataVolta);
    }
}

package com.thoughtworks.aceleradora.airline.dominio;

import java.time.LocalDate;

public class Busca {

    private String origem;
    private String destino;
    private int adultos;
    private LocalDate dataIda;
    private LocalDate dataVolta;

    public Busca() {
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
}

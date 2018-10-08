package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Aeroporto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String iata;

    private String nome;

    private String cidade;

    public Aeroporto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

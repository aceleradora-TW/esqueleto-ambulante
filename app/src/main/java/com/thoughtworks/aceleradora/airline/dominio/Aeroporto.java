package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Aeroporto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String iata;

    private String nome;

    private String cidade;

    public Aeroporto(String iata, String nome, String cidade) {
        this.iata = iata;
        this.nome = nome;
        this.cidade = cidade;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeroporto aeroporto = (Aeroporto) o;
        return Objects.equals(id, aeroporto.id) &&
                Objects.equals(iata, aeroporto.iata) &&
                Objects.equals(nome, aeroporto.nome) &&
                Objects.equals(cidade, aeroporto.cidade);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, iata, nome, cidade);
    }

    @Override
    public String toString() {
        return "Aeroporto{" +
                "id=" + id +
                ", iata='" + iata + '\'' +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}

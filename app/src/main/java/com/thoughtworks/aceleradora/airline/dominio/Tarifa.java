package com.thoughtworks.aceleradora.airline.dominio;

import java.math.BigDecimal;
import java.util.Objects;

public class Tarifa {

    private Long id;

    private String categoria;

    private BigDecimal preco;

    public Tarifa() {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarifa tarifa = (Tarifa) o;
        return Objects.equals(id, tarifa.id) &&
                Objects.equals(categoria, tarifa.categoria) &&
                Objects.equals(preco, tarifa.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoria, preco);
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", preco=" + preco +
                '}';
    }
}

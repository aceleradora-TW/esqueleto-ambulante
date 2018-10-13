package com.thoughtworks.aceleradora.airline.dominio;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "atributo_tarifario")
public class AtributoTarifario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Regulacao regulacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "permissao_regulacao")
    private PermissaoRegulacao permissao;

    public AtributoTarifario(Regulacao regulacao, PermissaoRegulacao permissao) {
        this.regulacao = regulacao;
        this.permissao= permissao;
    }

    public AtributoTarifario() {
    }

    public Regulacao getRegulacao() {
        return regulacao;
    }

    public void setRegulacao(Regulacao regulacao) {
        this.regulacao = regulacao;
    }

    public PermissaoRegulacao getPermissao() {
        return permissao;
    }

    public void setPermissao(PermissaoRegulacao permissao) {
        this.permissao = permissao;
    }
}

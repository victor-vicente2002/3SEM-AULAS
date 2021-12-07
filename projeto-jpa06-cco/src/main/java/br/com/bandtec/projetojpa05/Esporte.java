package br.com.bandtec.projetojpa05;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Esporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne// Esta anotação configura o relacionamento entre as entidades
    private TipoEsporte tipo;
    // aqui podemos dizer que "um Esporte tem um TipoEsporte" ou "um Esporte é de um TipoEsporte"

    // daqui em diante só get e set


    public TipoEsporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoEsporte tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

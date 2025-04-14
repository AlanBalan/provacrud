package com.example.provacrud.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public PessoaModel() {}

    @OneToMany(mappedBy = "pessoa")
    private List<TrabalhoModel> trabalhos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TrabalhoModel> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(List<TrabalhoModel> trabalhos) {
        this.trabalhos = trabalhos;
    }

}

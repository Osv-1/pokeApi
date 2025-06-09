package com.br.pokeApi.model;

import javax.persistence.*;


@Entity
@Table(name = "POKEMON")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Alterado para IDENTITY
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private Integer height;

    @Column
    private Integer weight;

    // Construtores
    public Pokemon() {
        // Construtor padrão necessário para JPA
    }

    public Pokemon(String name, String type, Integer height, Integer weight) {
        this.name = name;
        this.type = type;
        this.height = height != null ? height : 0;
        this.weight = weight != null ? weight : 0;
    }

    public Pokemon(String name) {
        this.name = name;
    }

    // Remova o construtor problemático
    // public Pokemon(String name) {}

    // Getters e Setters (mantidos como estão)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height != null ? height : 0;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight != null ? weight : 0;
    }

    // Adicione toString() para facilitar debugging
    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
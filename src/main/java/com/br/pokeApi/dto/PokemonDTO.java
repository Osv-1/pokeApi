package com.br.pokeApi.dto;

public class PokemonDTO {

    private String name;

    public PokemonDTO(String name) {
        this.name = name;
    }

    public PokemonDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

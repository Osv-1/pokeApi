package com.br.pokeApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class PokemonQueryDTO {


    List<String> result = new ArrayList<>();

    public PokemonQueryDTO(List<String> names) {
        this.result = names;
    }

    public PokemonQueryDTO(String name) {
        this.result.add(name);
    }

    public PokemonQueryDTO() {

    }

    @JsonProperty("result")
    public List<String> getNames() {
        return result;
    }

    public void setNames(List<String> names) {
        this.result = names;
    }

    public void setResult(String name) {
        this.result.add(name);
    }


}

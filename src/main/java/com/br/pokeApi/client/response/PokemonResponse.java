package com.br.pokeApi.client.response;

import com.br.pokeApi.dto.PokemonDTO;
import com.br.pokeApi.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonResponse {
    List<PokemonDTO> results;

    public List<Pokemon> toPokemon() {

        ArrayList<Pokemon> pokemonList = new ArrayList<>();

        for (PokemonDTO result : results) {
            pokemonList.add(new Pokemon(result.getName()));

        }
        return pokemonList;

    }

    public PokemonResponse(List<PokemonDTO> results) {
        this.results = results;
    }

    public PokemonResponse() {

    }

    public List<PokemonDTO> getResults() {
        return results;
    }

    public void setResults(List<PokemonDTO> results) {
        this.results = results;
    }
}

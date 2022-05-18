package com.br.pokeApi.service;

import com.br.pokeApi.dto.PokemonHighlightDTO;
import com.br.pokeApi.dto.PokemonQueryDTO;
import com.br.pokeApi.model.Pokemon;
import com.br.pokeApi.repository.PokemonRepository;
import com.br.pokeApi.utils.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    Sort sortService = new Sort();

    public void saveAll(List<Pokemon> pokemons) {
        for (Pokemon pokemon : pokemons) {
            pokemonRepository.saveAll(pokemons);
        }

    }

    public PokemonQueryDTO getAllPokemonsByName(String name, String sort) {
        PokemonQueryDTO pokemonQueryDTOS = new PokemonQueryDTO();
        List<Pokemon> sortedPokemons = new ArrayList<>();


        //Switch case for 2 cases, Alphabetical order and Length order
        switch (sort) {
            case "alphabetical": {
                sortedPokemons = sortService.sortAphabetical((ArrayList<Pokemon>) pokemonRepository.findAll());
                break;
            }
            case "length": {
                sortedPokemons = sortService.sortLength((ArrayList<Pokemon>) pokemonRepository.findAll());

            }
        }

        for (Pokemon pokemon : sortedPokemons) {
            if (pokemon.getName().contains(name)) {
                pokemonQueryDTOS.setResult(pokemon.getName());
            }
        }
        return pokemonQueryDTOS;
    }

    //Method that highlights the part of the string searched in the database.
    //A query returned object list (PokemonHighlightDTO) populated.
    public List<PokemonHighlightDTO> findByNameHighlight(String query) {
        List<Pokemon> pokemonsList = pokemonRepository.findAll();
        List<PokemonHighlightDTO> nameHighlight = new ArrayList<>();
        if (!pokemonsList.isEmpty()) {
            for (Pokemon pokemon : pokemonsList) {
                if (pokemon.getName().contains(query)) {
                    nameHighlight.add(highlightString(pokemon.getName(), query));
                }

            }
        }
        return nameHighlight;
    }

    //Method that marks the part of the searched text.
    //Returns a list of PokemonHighlightDTO filled with the information.
    private PokemonHighlightDTO highlightString(String name, String query) {
        int start = name.indexOf(query);
        int end = start + query.length() - 1;

        PokemonHighlightDTO pokemonHighlightDTO = new PokemonHighlightDTO();

        pokemonHighlightDTO.setName(name);
        pokemonHighlightDTO.setStart(start);
        pokemonHighlightDTO.setEnd(end);

        return pokemonHighlightDTO;
    }
}

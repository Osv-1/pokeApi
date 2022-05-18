package com.br.pokeApi.utils;

import com.br.pokeApi.model.Pokemon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Sort {

    //Sort the Pokemon list with BubbleSort,
    //and sort the Pokemon list with PokemonServiceImpl.getAllPokemonsByName
    //A list of Pokemon by length and alphabetical order
    BubbleSort sort = new BubbleSort();

    public ArrayList<Pokemon> sortAphabetical(ArrayList<Pokemon> pokemons) {
        int left = 0;
        int right = pokemons.size() - 1;

        return sort.quickSortAlphabetical
                (
                        pokemons,
                        left,
                        right
                );

    }
    public ArrayList<Pokemon> sortLength(ArrayList<Pokemon> pokemons) {
        int left = 0;
        int right = pokemons.size() - 1;

        return sort.quickSortLength
                (
                        pokemons,
                        left,
                        right
                );

    }
}

package com.br.pokeApi.utils;

import com.br.pokeApi.model.Pokemon;

import java.util.ArrayList;
import java.util.Collections;

//Class responsible to sort a list by alphabet and length
public class BubbleSort {
    //Alphabetical order: Sorts a list of strings (pokemon names) according to their initials,
    //returning an int value to determine which string comes first.
    //Returns a list of strings (pokemon names) filtered in alphabetical order.
    public int Alphabetical(ArrayList<Pokemon> pokemonsList, int left, int right) {
        Pokemon pivot = pokemonsList.get(left);
        int i = left;

        for (int j = left + 1; j <= right; j++) {
            if (pokemonsList.get(j).getName().compareTo(pivot.getName()) < 0) {
                i += 1;
                Collections.swap(pokemonsList, i, j);
            }
        }
        Collections.swap(pokemonsList, left, i);
        return i;
    }
    //Name Length: Sorts a list of strings (pokemon names) according to their length.
    //Returns a list of strings (pokemon names) sorted in order of string length.

    //Split a list into two other lists PokemonsList Pokemon List Left side of Pokémon list
    //Right side of Pokemon list Returns the sorted list of Pokémon
    public int Length(ArrayList<Pokemon> pokemonsList, int left, int right) {
        Pokemon pivot = pokemonsList.get(left);
        int i = left;

        for (int j = left + 1; j <= right; j++) {
            if (pokemonsList.get(j).getName().length() < pivot.getName().length()) {
                i += 1;
                Collections.swap(pokemonsList, i, j);
            }
        }

        Collections.swap(pokemonsList, left, i);
        return i;
    }
    //Use BubbleSort to sort the Pokémon list in ascending order (by name length).Pokemon List =
    // Left side of Pokémon list. Right side of Pokemon list. Returns an alphabetical list of Pokemon
    public ArrayList<Pokemon> quickSortAlphabetical(ArrayList<Pokemon> pokemonsList, int left, int right) {
        if (left < right) {
            int partition = Alphabetical(pokemonsList, left, right);
            quickSortAlphabetical(pokemonsList, left, partition - 1);
            quickSortAlphabetical(pokemonsList, partition + 1, right);
        }
        return pokemonsList;
    }
    public ArrayList<Pokemon> quickSortLength(ArrayList<Pokemon> pokemonsList, int left, int right) {
        if (left < right) {
            int partition = Length(pokemonsList, left, right);
            quickSortLength(pokemonsList, left, partition - 1);
            quickSortLength(pokemonsList, partition + 1, right);
        }
        return pokemonsList;
    }
}

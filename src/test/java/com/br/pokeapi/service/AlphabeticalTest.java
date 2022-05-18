package com.br.pokeapi.service;


import com.br.pokeApi.model.Pokemon;
import com.br.pokeApi.repository.PokemonRepository;
import com.br.pokeApi.service.PokemonService;
import com.br.pokeApi.utils.BubbleSort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AlphabeticalTest {

    @InjectMocks
    private PokemonService pokemonService;

    @MockBean
    private PokemonRepository pokemonRepository;

    private final BubbleSort sortAlphabetical = new BubbleSort();

    private static final List<Pokemon> unsortList = new ArrayList<>();
    private static final List<Pokemon> sortedAlphabet = new ArrayList<>();

    static {

        unsortList.addAll(Arrays.asList(
                new Pokemon("Gastly"),
                new Pokemon("Haunter"),
                new Pokemon("Gengar"),
                new Pokemon("Charizard"),
                new Pokemon("Pikachu"),
                new Pokemon("Mew"),
                new Pokemon("Mewtwo"),
                new Pokemon("Charmander"),
                new Pokemon("Snorlax"),
                new Pokemon("Caterpie"),
                new Pokemon("Pidgey"),
                new Pokemon("Pidgeotto")
        ));


        sortedAlphabet.addAll(Arrays.asList(
                new Pokemon("Caterpie"),
                new Pokemon("Charizard"),
                new Pokemon("Charmander"),
                new Pokemon("Gastly"),
                new Pokemon("Gengar"),
                new Pokemon("Haunter"),
                new Pokemon("Mew"),
                new Pokemon("Mewtwo"),
                new Pokemon("Pidgeotto"),
                new Pokemon("Pidgey"),
                new Pokemon("Pikachu"),
                new Pokemon("Snorlax")


        ));
    }

    @Test
    public void sortAlphabeticalTest() {
        List<String> expected = sortedAlphabet.stream().map(Pokemon::getName).collect(Collectors.toList());
        List<String> actual = sortAlphabetical.quickSortAlphabetical((ArrayList<Pokemon>) unsortList, 0, unsortList.size() - 1)
                .stream()
                .map(Pokemon::getName)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }
}

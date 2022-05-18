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
public class LengthTest {

    @InjectMocks
    private PokemonService pokemonService;

    @MockBean
    private PokemonRepository pokemonRepository;

    private final BubbleSort sortLength = new BubbleSort();

    private static final List<Pokemon> sortedLength = new ArrayList<>();

    private static final List<Pokemon> unsortList = new ArrayList<>();

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


        sortedLength.addAll(Arrays.asList(
                new Pokemon("Mew"),
                new Pokemon("Gastly"),
                new Pokemon("Gengar"),
                new Pokemon("Pidgey"),
                new Pokemon("Mewtwo"),
                new Pokemon("Pikachu"),
                new Pokemon("Haunter"),
                new Pokemon("Snorlax"),
                new Pokemon("Caterpie"),
                new Pokemon("Charizard"),
                new Pokemon("Pidgeotto"),
                new Pokemon("Charmander")
        ));
    }


    @Test
    public void sortLengthTest() {
        List<String> expected = sortedLength.stream().map(Pokemon::getName).collect(Collectors.toList());
        List<String> actual = sortLength.quickSortLength((ArrayList<Pokemon>) unsortList, 0, unsortList.size() - 1)
                .stream()
                .map(Pokemon::getName)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }
}

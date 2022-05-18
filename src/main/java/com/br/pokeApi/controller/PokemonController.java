package com.br.pokeApi.controller;

import com.br.pokeApi.dto.PokemonHighlightDTO;
import com.br.pokeApi.dto.PokemonQueryDTO;
import com.br.pokeApi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    //RequestParam Sort for results in order, alphabetical or length
    @GetMapping("pokemons")
    public ResponseEntity<PokemonQueryDTO> getAllPokemonsByName(@RequestParam("q") String name,
                                                                @RequestParam("sort") String sort) {

        return ResponseEntity.ok(pokemonService.getAllPokemonsByName(name, sort));

    }

    @GetMapping("highlight")
    public List<PokemonHighlightDTO> highlightName(@RequestParam("q") String query) {
        return pokemonService.findByNameHighlight(query);
    }


}

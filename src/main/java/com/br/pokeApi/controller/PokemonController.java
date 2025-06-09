package com.br.pokeApi.controller;

import com.br.pokeApi.dto.PokemonHighlightDTO;
import com.br.pokeApi.dto.PokemonQueryDTO;
import com.br.pokeApi.model.Pokemon;
import com.br.pokeApi.repository.PokemonRepository;
import com.br.pokeApi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private PokemonRepository repository;

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


    @PostMapping
    public Pokemon salvar(@RequestBody Pokemon pokemon) {
        return repository.save(pokemon);
    }

    @GetMapping
    public List<Pokemon> listar() {
        return repository.findAll();
    }


}

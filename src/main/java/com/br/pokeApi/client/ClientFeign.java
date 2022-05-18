package com.br.pokeApi.client;


import com.br.pokeApi.client.response.PokemonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "get", url = "https://pokeapi.co/api/v2")
public interface ClientFeign {

    @GetMapping("/pokemon?limit=151")
    PokemonResponse getAllPokemons();

}

package com.br.pokeApi;


import com.br.pokeApi.client.ClientFeign;
import com.br.pokeApi.client.response.PokemonResponse;
import com.br.pokeApi.model.Pokemon;
import com.br.pokeApi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@EnableFeignClients
@SpringBootApplication
@EntityScan("com.br.pokeApi.model")
@EnableJpaRepositories("com.br.pokeApi.repository")
public class PokeapiApplication implements CommandLineRunner {

    @Autowired
    ClientFeign clientFeign;

    @Autowired
    PokemonService pokemonService;

    public static void main(String[] args) {
        SpringApplication.run(PokeapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PokemonResponse pokemonResponse = clientFeign.getAllPokemons();
        List<Pokemon> pokemons = pokemonResponse.toPokemon();

        pokemonService.saveAll(pokemons);
    }

}

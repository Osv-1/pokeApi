package com.br.pokeApi.service;

import com.br.pokeApi.model.Pokemon;
import com.br.pokeApi.repository.PokemonRepository;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokeApiService implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(PokeApiService.class);

    private final RestTemplate restTemplate;
    private final PokemonRepository pokemonRepository;

    public PokeApiService(PokemonRepository pokemonRepository) {
        this.restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(5))
                .setReadTimeout(Duration.ofSeconds(10))
                .build();
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    @Transactional

    public void run(String... args) {
        loadPokemons();
    }
    @EventListener(ApplicationReadyEvent.class)
    public void loadPokemons() {
        try {
            logger.info("Iniciando carga de Pokémons...");
            // pokemonRepository.deleteAll(); // Para debug, pode deixar comentado

            String apiUrl = "https://pokeapi.co/api/v2/pokemon?limit=20";
            ApiResponse response = restTemplate.getForObject(apiUrl, ApiResponse.class);

            if (response != null && response.results != null) {
                for (PokemonEntry entry : response.results) {
                    try {
                        PokemonDetail detail = restTemplate.getForObject(entry.url, PokemonDetail.class);

                        if (detail != null) {
                            String types = detail.types != null ?
                                    detail.types.stream()
                                            .map(t -> t.type != null ? t.type.name : "unknown")
                                            .collect(Collectors.joining(", ")) :
                                    "unknown";

                            Integer height = detail.height != null ? detail.height : 0;
                            Integer weight = detail.weight != null ? detail.weight : 0;

                            Pokemon pokemon = new Pokemon(
                                    detail.name,
                                    types,
                                    height,
                                    weight
                            );

                            pokemonRepository.save(pokemon);
                            logger.info("Pokémon salvo: {}", detail.name);
                            System.out.println("Pokemon persistido: " + pokemon);
                        } else {
                            logger.warn("Detalhes nulos para: {}", entry.name);
                        }
                    } catch (Exception e) {
                        logger.error("Erro ao processar Pokémon {}", entry.name, e);
                    }
                }
                logger.info("Carga de Pokémons concluída com sucesso! Total: {}", pokemonRepository.count());
            } else {
                logger.warn("Resposta vazia da API!");
            }
        } catch (Exception e) {
            logger.error("Erro ao carregar Pokémons", e);
        }
    }

    @Data
    private static class ApiResponse {
        public List<PokemonEntry> results;
    }

    @Data
    private static class PokemonEntry {
        public String name;
        public String url;
    }

    @Data
    private static class PokemonDetail {
        public String name;
        public Integer height;
        public Integer weight;
        public List<PokemonType> types;
    }

    @Data
    private static class PokemonType {
        public Type type;
    }

    @Data
    private static class Type {
        public String name;
    }
}

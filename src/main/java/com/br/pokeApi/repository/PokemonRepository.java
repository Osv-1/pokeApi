package com.br.pokeApi.repository;

import com.br.pokeApi.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {


}

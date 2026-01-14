package io;

import model.Pokemon;

import java.util.stream.Stream;

public interface Store {
    Stream<Pokemon> pokemons();
}

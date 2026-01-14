package app;

import model.Pokemon;
import tasks.HistogramBuilder;
import viewmodel.Histogram;

import java.util.stream.Stream;

import static model.Pokemon.*;

public class Main {
    static void main() {
        MainFrame.create()
                .display(histogramOf(pokemons()))
                .setVisible(true);
    }

    private static Histogram<Type> histogramOf(Stream<Pokemon> pokemons) {
        return HistogramBuilder.with(pokemons)
                .title("Pokemons per Type")
                .x("Types")
                .y("Count")
                .legend("Pokemons")
                .build(p -> p.types().stream());
    }

    private static Stream<Pokemon> pokemons() {
        return new RemoteStore(CsvPokeParser::parse).pokemons();
    }
}

package fish.payara.resource.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fish.payara.resource.model.Game;

public class GameRepository {
    private List<Game> gamelist;

    public GameRepository() {
        gamelist = new ArrayList<>();

        Game[] games = {
                new Game(1L,
                        "Dark Souls",
                        "Bandai Namco",
                        LocalDate.of(2011, 9, 22),
                        "https://pt.wikipedia.org/wiki/Dark_Souls#/media/Ficheiro:Dark_Souls_1_capa.png"),

                new Game(2L,
                        "Resident Evil 3",
                        "CAPCOM",
                        LocalDate.of(1999, 9, 22),
                        "https://pt.wikipedia.org/wiki/Resident_Evil_3:_Nemesis"),

                new Game(3L,
                        "The Last of Us",
                        "Naughty Dog",
                        LocalDate.of(2013, 6, 14),
                        "https://pt.wikipedia.org/wiki/The_Last_of_Us#/media/Ficheiro:The_Last_of_Us_cover_art.jpg"),

                new Game(4L,
                        "God of War",
                        "Santa Monica Studio",
                        LocalDate.of(2018, 4, 20),
                        "https://pt.wikipedia.org/wiki/God_of_War_(2018)"),

                new Game(5L,
                        "Horizon Zero Dawn",
                        "Guerrilla Games",
                        LocalDate.of(2017, 2, 28),
                        "https://pt.wikipedia.org/wiki/Horizon_Zero_Dawn"),

                new Game(6L,
                        "Bloodborne",
                        "FromSoftware",
                        LocalDate.of(2015, 3, 24),
                        "https://pt.wikipedia.org/wiki/Bloodborne"),

                new Game(7L,
                        "Red Dead Redemption 2",
                        "Rockstar Games",
                        LocalDate.of(2018, 10, 26),
                        "https://pt.wikipedia.org/wiki/Red_Dead_Redemption_2"),

                new Game(8L,
                        "The Witcher 3: Wild Hunt",
                        "CD Projekt RED",
                        LocalDate.of(2015, 5, 19),
                        "https://pt.wikipedia.org/wiki/The_Witcher_3:_Wild_Hunt")
        };
        gamelist.addAll(Arrays.asList(games));
    }

    public List<Game> getGamelist() {
        return gamelist;
    }
}

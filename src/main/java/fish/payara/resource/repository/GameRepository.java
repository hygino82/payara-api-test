package fish.payara.resource.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import fish.payara.resource.model.Game;

public class GameRepository {

        private List<Game> gamelist;
        private static GameRepository instance;

        public static GameRepository getInstance() {
                if (instance == null) {
                        instance = new GameRepository();
                }
                return instance;
        }

        private GameRepository() {
                gamelist = new ArrayList<>();

                gamelist.addAll(Arrays.asList(
                                new Game(1L,
                                                "Dark Souls",
                                                "Bandai Namco",
                                                LocalDate.of(2011, 9, 22),
                                                "https://pt.wikipedia.org/wiki/Dark_Souls#/media/Ficheiro:Dark_Souls_1_capa.png",
                                                LocalDateTime.parse("2025-03-12T09:47:00"),
                                                null),

                                new Game(2L,
                                                "Resident Evil 3",
                                                "CAPCOM",
                                                LocalDate.of(1999, 9, 22),
                                                "https://pt.wikipedia.org/wiki/Resident_Evil_3:_Nemesis",
                                                LocalDateTime.parse("2025-03-12T09:47:00"),
                                                null),

                                new Game(3L,
                                                "The Last of Us",
                                                "Naughty Dog",
                                                LocalDate.of(2013, 6, 14),
                                                "https://pt.wikipedia.org/wiki/The_Last_of_Us#/media/Ficheiro:The_Last_of_Us_cover_art.jpg",
                                                LocalDateTime.parse("2025-03-12T09:47:00"),
                                                null),

                                new Game(4L,
                                                "God of War",
                                                "Santa Monica Studio",
                                                LocalDate.of(2018, 4, 20),
                                                "https://pt.wikipedia.org/wiki/God_of_War_(2018)",
                                                LocalDateTime.parse("2025-03-12T09:47:00"),
                                                null),

                                new Game(5L,
                                                "Horizon Zero Dawn",
                                                "Guerrilla Games",
                                                LocalDate.of(2017, 2, 28),
                                                "https://pt.wikipedia.org/wiki/Horizon_Zero_Dawn",
                                                LocalDateTime.parse("2025-03-12T09:47:00"),
                                                null),

                                new Game(6L,
                                                "Bloodborne",
                                                "FromSoftware",
                                                LocalDate.of(2015, 3, 24),
                                                "https://pt.wikipedia.org/wiki/Bloodborne",
                                                LocalDateTime.parse("2025-03-12T09:47:00"),
                                                null),

                                new Game(7L,
                                                "Red Dead Redemption 2",
                                                "Rockstar Games",
                                                LocalDate.of(2018, 10, 26),
                                                "https://pt.wikipedia.org/wiki/Red_Dead_Redemption_2",
                                                LocalDateTime.parse("2025-03-12T09:47:00"),
                                                null),

                                new Game(8L,
                                                "The Witcher 3: Wild Hunt",
                                                "CD Projekt RED",
                                                LocalDate.of(2015, 5, 19),
                                                "https://pt.wikipedia.org/wiki/The_Witcher_3:_Wild_Hunt",
                                                LocalDateTime.parse("2025-03-12T09:47:00"),
                                                null)));
        }

        public List<Game> getGamelist() {
                return gamelist;
        }

        public Game insert(Game game) {
                game.setId((long) (Math.random() * 1000));
                gamelist.add(game);
                return game;
        }

        public boolean removeGameById(long id) {
                final Predicate<Game> buscaPorId = g -> g.getId() == id;
                return gamelist.removeIf(buscaPorId);
        }
}

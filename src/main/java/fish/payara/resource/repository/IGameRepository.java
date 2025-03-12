package fish.payara.resource.repository;

import fish.payara.resource.model.Game;

import java.util.List;
import java.util.Optional;

public interface IGameRepository {

    List<Game> findAllGames();

    Optional<Game> findGameById(long id);

    Game updateGame(long id,Game entity);

    Game insertGame(Game entity);

    boolean removeGame(long id);
}

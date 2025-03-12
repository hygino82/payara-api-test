package fish.payara.resource.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import fish.payara.resource.dto.RequestGameDTO;
import fish.payara.resource.dto.ResponseGameDTO;
import fish.payara.resource.model.Game;
import fish.payara.resource.repository.GameRepository;
import fish.payara.resource.repository.IGameRepository;
import fish.payara.resource.service.exceptions.GameNotFoundException;
import jakarta.inject.Inject;

public class GameService {

    private final GameRepository repository = GameRepository.getInstance();

    private final IGameRepository gameRepository;

    @Inject
    public GameService(IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<ResponseGameDTO> getGamelist() {
        final List<Game> res = gameRepository.findAllGames();
        return res.stream().map(ResponseGameDTO::new).toList();
    }

    public ResponseGameDTO insertGame(RequestGameDTO dto) {
        Game entity = new Game();
        dtoToEntity(dto, entity);
        entity.setCreateAt(LocalDateTime.now());

        return new ResponseGameDTO(gameRepository.insertGame(entity));
    }

    private void dtoToEntity(RequestGameDTO dto, Game entity) {
        entity.setName(dto.name());
        entity.setPublisher(dto.publisher());
        entity.setImageUrl(dto.imageUrl());
        entity.setReleaseDate(dto.releaseDate());
    }


    public ResponseGameDTO updateGame(long id, RequestGameDTO dto) {

        final Optional<Game> res = gameRepository.findGameById(id);

        if (res.isEmpty()) {
            throw new GameNotFoundException("Impossível atualizar o jogo, o Id:" + id + " não existe!");
        }

        Game entity = res.get();
        dtoToEntity(dto, entity);
        //entity.setUpdateAt(LocalDateTime.now());
        return new ResponseGameDTO(gameRepository.updateGame(id, entity));
    }

    public ResponseGameDTO findGameById(long id) {
        final Optional<Game> res = gameRepository.findGameById(id);

        if (res.isEmpty()) {
            throw new GameNotFoundException("Não existe  jogo com o Id:" + id);
        }

        return new ResponseGameDTO(res.get());
    }

    public boolean removeGameById(long id) {
        return gameRepository.removeGame(id);
    }
}

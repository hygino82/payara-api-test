package fish.payara.resource.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import fish.payara.resource.dto.RequestGameDTO;
import fish.payara.resource.dto.ResponseGameDTO;
import fish.payara.resource.model.Game;
import fish.payara.resource.repository.GameRepository;

public class GameService {

    private final GameRepository repository = GameRepository.getInstance();

    public List<ResponseGameDTO> getGamelist() {
        final List<Game> res = repository.getGamelist();
        return res.stream().map(ResponseGameDTO::new).sorted(sortByName()).toList();
    }

    public ResponseGameDTO insertGame(RequestGameDTO dto) {
        Game entity = new Game();
        dtoToEntity(dto, entity);
        entity.setCreateAt(LocalDateTime.now());

        return new ResponseGameDTO(repository.insert(entity));
    }

    private void dtoToEntity(RequestGameDTO dto, Game entity) {
        entity.setName(dto.name());
        entity.setPublisher(dto.publisher());
        entity.setImageUrl(dto.imageUrl());
        entity.setReleaseDate(dto.releaseDate());
    }

    /*private Comparator<ResponseGameDTO> sortById() {
        return new Comparator<ResponseGameDTO>() {

            @Override
            public int compare(ResponseGameDTO game1, ResponseGameDTO game2) {
                return game1.id().compareTo(game2.id());
            }
        };
    }*/

    private Comparator<ResponseGameDTO> sortByName() {
        return new Comparator<ResponseGameDTO>() {

            @Override
            public int compare(ResponseGameDTO game1, ResponseGameDTO game2) {
                return game1.name().compareTo(game2.name());
            }
        };
    }
}

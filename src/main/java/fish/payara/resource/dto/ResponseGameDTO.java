package fish.payara.resource.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fish.payara.resource.model.Game;

public record ResponseGameDTO(
                Long id,
                String name,
                String publisher,
                LocalDate releaseDate,
                String imageUrl,
                LocalDateTime createAt,
                LocalDateTime updateAt) {
                        
        public ResponseGameDTO(Game entity) {
                this(entity.getId(),
                     entity.getName(),
                     entity.getPublisher(),
                     entity.getReleaseDate(),
                     entity.getImageUrl(),
                     entity.getCreateAt(),
                     entity.getUpdateAt());
        }
}

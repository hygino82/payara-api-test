package fish.payara.resource.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fish.payara.resource.model.Console;

public record ResponseConsoleDTO(
        Long id,
        String name,
        String company,
        LocalDate releaseDate,
        String imageUrl,
        LocalDateTime createAt,
        LocalDateTime updateAt) {

    public ResponseConsoleDTO(Console entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getCompany(),
                entity.getReleaseDate(),
                entity.getImageUrl(),
                entity.getCreateAt(),
                entity.getUpdateAt());
    }
}

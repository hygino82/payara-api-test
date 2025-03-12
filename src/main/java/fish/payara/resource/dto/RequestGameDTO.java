package fish.payara.resource.dto;

import java.time.LocalDate;

public record RequestGameDTO(
        String name,
        String publisher, 
        LocalDate releaseDate,
        String imageUrl) {

}

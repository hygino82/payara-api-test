package fish.payara.resource.dto;

import java.time.LocalDate;

public record RequestConsoleDTO(
        String name,
        String company,
        LocalDate releaseDate,
        String imageUrl) {

}

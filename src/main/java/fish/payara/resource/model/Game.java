package fish.payara.resource.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Game {
    private Long id;
    private String name;
    private String publisher;
    private LocalDate releaseDate;
    private String imageUrl;
}

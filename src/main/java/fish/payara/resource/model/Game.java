package fish.payara.resource.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Game implements Serializable {
    private Long id;
    private String name;
    private String publisher;
    private LocalDate releaseDate;
    private String imageUrl;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}

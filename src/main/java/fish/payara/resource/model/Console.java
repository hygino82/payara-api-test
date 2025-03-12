package fish.payara.resource.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Console")
@Table(name = "Console")
public class Console implements Serializable {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String company;
    private LocalDate releaseDate;
    private String imageUrl;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
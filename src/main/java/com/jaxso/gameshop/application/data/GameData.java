package com.jaxso.gameshop.application.data;

import com.jaxso.gameshop.core.director.Director;
import com.jaxso.gameshop.core.game.Game;
import com.jaxso.gameshop.core.producer.Producer;
import com.jaxso.gameshop.core.protagonist.Protagonist;
import com.jaxso.gameshop.core.technology.Technology;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Johny Soto
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class GameData {
    @Id
    private String id = UUID.randomUUID().toString();

    @NotNull
    @Length(min = 1, max = 50)
    private String name;
    @NotNull
    @Min(0)
    private BigDecimal price;
    @NotNull
    private Date releaseDate;
    @NotNull
    @Length(min = 1, max = 50)
    private String directorId;
    @NotNull
    @Length(min = 1, max = 50)
    private String producerId;
    @NotNull
    @Length(min = 1, max = 50)
    private String technologyId;

    @NotNull
    @Size(min = 1)
    private Set<Protagonist> protagonists = new HashSet<>();


    public Game toGame() {
        Game game = new Game();
        game.setId(id);
        game.setName(name);
        game.setPrice(price);
        game.setReleaseDate(releaseDate);
        game.setDirector(new Director(directorId));
        game.setProducer(new Producer(directorId));
        game.setTechnology(new Technology(directorId));
        game.setProtagonists(protagonists);
        return game;
    }
}

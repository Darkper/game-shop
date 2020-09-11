package com.jaxso.gameshop.core.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaxso.gameshop.application.data.GameData;
import com.jaxso.gameshop.core.director.Director;
import com.jaxso.gameshop.core.producer.Producer;
import com.jaxso.gameshop.core.protagonist.Protagonist;
import com.jaxso.gameshop.core.rent.RentGame;
import com.jaxso.gameshop.core.technology.Technology;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
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
@Entity
@Table(name = "games")
public class Game {
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
    @JoinColumn(name = "director_id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Director director;

    @NotNull
    @JoinColumn(name = "producer_id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Producer producer;

    @NotNull
    @JoinColumn(name = "technology_id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Technology technology;

    @NotNull
    @Size(min = 1)
    @ManyToMany()
    @JoinTable(name = "game_protagonists",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "protagonist_id"))
    private Set<Protagonist> protagonists = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private Set<RentGame> rentGames;

    public Game(String id) {
        this.id = id;
    }

    public GameData toData() {
        GameData gameData = new GameData();
        gameData.setId(id);
        gameData.setName(name);
        gameData.setPrice(price);
        gameData.setReleaseDate(releaseDate);
        gameData.setDirectorId(director.getId());
        gameData.setProducerId(producer.getId());
        gameData.setTechnologyId(technology.getId());
        gameData.setProtagonists(protagonists);
        return gameData;
    }
}

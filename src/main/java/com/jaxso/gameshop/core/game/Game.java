package com.jaxso.gameshop.core.game;

import com.jaxso.gameshop.core.director.Director;
import com.jaxso.gameshop.core.producer.Producer;
import com.jaxso.gameshop.core.protagonist.Protagonist;
import com.jaxso.gameshop.core.rent.RentGame;
import com.jaxso.gameshop.core.technology.Technology;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Johny Soto
 */

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "games")
public class Game {
    @Id
    private final String id = UUID.randomUUID().toString();
    private String name;
    private BigDecimal price;
    private Date releaseDate;

    @JoinColumn(name = "director_id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Director director;

    @JoinColumn(name = "producer_id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Producer producer;

    @JoinColumn(name = "technology_id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Technology technology;

    @ManyToMany()
    @JoinTable(name = "game_protagonists",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "protagonist_id"))
    private Set<Protagonist> protagonists = new HashSet<>();

    @OneToMany(mappedBy = "game")
    Set<RentGame> rentGames;

}

package com.jaxso.gameshop.core.game;

import com.jaxso.gameshop.core.director.Director;
import com.jaxso.gameshop.core.producer.Producer;
import com.jaxso.gameshop.core.protagonist.Protagonist;
import com.jaxso.gameshop.core.technology.Technology;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Johny Soto
 */

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Game {
    private String id;
    private String name;
    private BigDecimal price;
    private Date releaseDate;
    private Director director;
    private Producer producer;
    private Technology technology;
    private List<Protagonist> protagonists;

    public Game(String name, BigDecimal price, Date releaseDate, Director director, Producer producer, Technology technology, List<Protagonist> protagonists) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.director = director;
        this.producer = producer;
        this.technology = technology;
        this.protagonists = protagonists;
    }
}

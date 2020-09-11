package com.jaxso.gameshop.core.rent;

import com.jaxso.gameshop.core.game.Game;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Johny Soto
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class RentGame implements Serializable {
    @EmbeddedId
    RentGameKey id;

    @ManyToOne
    @MapsId("rentId")
    @JoinColumn(name = "rent_id")
    Rent rent;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    Game game;

    private int quantity;
    private BigDecimal price;
    private int daysOfRent;
}

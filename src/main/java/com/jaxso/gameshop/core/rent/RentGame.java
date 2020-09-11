package com.jaxso.gameshop.core.rent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaxso.gameshop.core.game.Game;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Johny Soto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class RentGame implements Serializable {
    @NotNull
    @EmbeddedId
    RentGameKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("rentId")
    @JoinColumn(name = "rent_id")
    Rent rent;

    @JsonIgnore
    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    Game game;

    @NotNull
    @Min(1)
    private int quantity;
    @NotNull
    @Min(0)
    private BigDecimal price;
    @NotNull
    @Min(1)
    private int daysOfRent;

    public static RentGame mapGame(RentGame rentGame, String rentId) {
        rentGame.setGame(new Game(rentGame.id.getGameId()));
        rentGame.setRent(new Rent(rentId));
        return rentGame;
    }
}

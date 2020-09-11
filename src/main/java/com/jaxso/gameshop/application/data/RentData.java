package com.jaxso.gameshop.application.data;

import com.jaxso.gameshop.core.client.Client;
import com.jaxso.gameshop.core.rent.Rent;
import com.jaxso.gameshop.core.rent.RentGame;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Johny Soto
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RentData {
    private String id = UUID.randomUUID().toString();

    @NotNull
    @Length(min = 1, max = 50)
    private String clientId;

    @NotNull
    private Date date;

    @NotNull
    @Size(min = 1)
    private Set<RentGame> rentGames;

    public Rent toRent() {
        Rent rent = new Rent();
        rent.setId(id);
        rent.setClient(new Client(clientId));
        rent.setDate(date);
        rent.setRentGames(rentGames.stream().map((RentGame rentGame) -> RentGame.mapGame(rentGame, id)).collect(Collectors.toSet()));
        return rent;
    }
}

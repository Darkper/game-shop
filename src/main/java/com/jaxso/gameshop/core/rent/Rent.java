package com.jaxso.gameshop.core.rent;

import com.jaxso.gameshop.application.data.RentData;
import com.jaxso.gameshop.core.client.Client;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
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
@Table(name = "rents")
public class Rent {
    @Id
    private String id = UUID.randomUUID().toString();

    @NotNull
    @JoinColumn(name = "client_id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Client client;

    @NotNull
    private Date date;

    @Size(min = 1)
    @OneToMany(mappedBy = "rent", cascade = CascadeType.ALL)
    private Set<RentGame> rentGames;


    public Rent(Client client, Date date) {
        this.client = client;
        this.date = date;
    }

    public Rent(String id) {
        this.id = id;
    }

    public RentData toData() {
        RentData rentData = new RentData();
        rentData.setId(id);
        rentData.setClientId(client.getDocument());
        rentData.setDate(date);
        rentData.setRentGames(rentGames);
        return rentData;
    }
}

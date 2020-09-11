package com.jaxso.gameshop.core.rent;

import com.jaxso.gameshop.core.client.Client;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private final String id = UUID.randomUUID().toString();

    @JoinColumn(name = "client_id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Client client;

    private Date date;

    @OneToMany(mappedBy = "rent")
    private Set<RentGame> rentGames;


    public Rent(Client client, Date date) {
        this.client = client;
        this.date = date;
    }
}

package com.jaxso.gameshop.core.rent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

/**
 * @author Johny Soto
 */
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Rent {
    private String id;
    private String clientId;
    private Date date;

    public Rent(String clientId, Date date) {
        this.id = UUID.randomUUID().toString();
        this.clientId = clientId;
        this.date = date;
    }
}

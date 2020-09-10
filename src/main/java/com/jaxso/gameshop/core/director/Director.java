package com.jaxso.gameshop.core.director;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author Johny Soto
 */
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Director {
    private String id;
    private String name;

    public Director(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}

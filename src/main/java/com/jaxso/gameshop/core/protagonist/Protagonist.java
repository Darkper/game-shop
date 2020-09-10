package com.jaxso.gameshop.core.protagonist;

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
public class Protagonist {
    private String id;
    private String name;

    public Protagonist(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}

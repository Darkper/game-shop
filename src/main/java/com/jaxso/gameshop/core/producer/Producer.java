package com.jaxso.gameshop.core.producer;

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
public class Producer {
    private String id;
    private String name;

    public Producer(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}

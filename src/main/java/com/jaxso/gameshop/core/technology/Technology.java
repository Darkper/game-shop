package com.jaxso.gameshop.core.technology;

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
public class Technology {
    private String id;
    private String name;

    public Technology(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}

package com.jaxso.gameshop.core.technology;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author Johny Soto
 */
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "technologies")
public class Technology {
    @Id
    private String id;
    private String name;

    public Technology(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}

package com.jaxso.gameshop.core.protagonist;

import com.jaxso.gameshop.core.game.Game;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
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
@Table(name = "protagonists")
public class Protagonist {
    @Id
    private final String id = UUID.randomUUID().toString();
    private String name;

    @ManyToMany(mappedBy = "protagonists")
    private Set<Game> posts = new HashSet<>();

    public Protagonist(String name) {
        this.name = name;
    }
}

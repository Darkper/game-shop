package com.jaxso.gameshop.core.protagonist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaxso.gameshop.core.game.Game;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private String id = UUID.randomUUID().toString();

    @NotNull
    @Length(min = 1, max = 50)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "protagonists", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Set<Game> games = new HashSet<>();

    public Protagonist(String name) {
        this.name = name;
    }
}

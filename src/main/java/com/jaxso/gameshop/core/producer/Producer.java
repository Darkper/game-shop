package com.jaxso.gameshop.core.producer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author Johny Soto
 */
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "producers")
public class Producer {
    @Id
    private String id = UUID.randomUUID().toString();

    @NotNull
    @Length(min = 1, max = 50)
    private String name;

    public Producer(String id) {
        this.id = id;
    }

    public Producer(String id, String name) {
        this.id = id;
        this.name = name;
    }


}

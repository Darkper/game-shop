package com.jaxso.gameshop.core.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Johny Soto
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "document")
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "document", nullable = false, insertable = true)
    private String document;
    private String name;
    private String lastName;
    private String phone;
    private String email;

    public Client(String document) {
        this.document = document;
    }
}

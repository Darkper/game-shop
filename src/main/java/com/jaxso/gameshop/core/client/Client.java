package com.jaxso.gameshop.core.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @Length(min = 1, max = 20)
    @Column(name = "document", nullable = false)
    private String document;

    @NotNull
    @Length(min = 1, max = 50)
    private String name;

    @NotNull
    @Length(min = 1, max = 50)
    private String lastName;

    @Length(max = 15)
    private String phone;

    @Email
    private String email;

    public Client(String document) {
        this.document = document;
    }
}

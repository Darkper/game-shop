package com.jaxso.gameshop.core.client;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Johny Soto
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "document")
public class Client {
    private String document;
    private String name;
    private String lastName;
    private String phone;
    private String email;

}

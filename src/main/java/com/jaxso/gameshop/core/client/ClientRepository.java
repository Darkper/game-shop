package com.jaxso.gameshop.core.client;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
public interface ClientRepository {
    void save(Client client);

    Optional<Client> findById(String id);

    List<Client> findAll();

    void remove(Client client);

    String getMoreFrequentClientId();
}

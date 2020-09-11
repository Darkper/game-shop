package com.jaxso.gameshop.core.protagonist;


import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
public interface ProtagonistRepository {
    void save(Protagonist protagonist);

    Optional<Protagonist> findById(String id);

    List<Protagonist> findAll();

    void remove(Protagonist protagonist);
}

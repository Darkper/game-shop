package com.jaxso.gameshop.core.technology;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
public interface TechnologyRepository {
    void save(Technology technology);

    Optional<Technology> findById(String id);

    List<Technology> findAll();

    void remove(Technology technology);
}

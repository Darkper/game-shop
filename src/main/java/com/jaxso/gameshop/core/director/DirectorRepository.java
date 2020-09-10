package com.jaxso.gameshop.core.director;

import com.jaxso.gameshop.core.technology.Technology;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
public interface DirectorRepository {
    void save(Technology technology);

    Optional<Technology> findById(String id);

    List<Technology> findAll();

    void remove(Technology technology);
}

package com.jaxso.gameshop.core.director;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
public interface DirectorRepository {
    void save(Director director);

    Optional<Director> findById(String id);

    List<Director> findAll();

    void remove(Director director);
}

package com.jaxso.gameshop.core.game;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
public interface GameReository {
    void save(Game game);

    Optional<Game> findById(int id);

    List<Game> findAll();

    void remove(Game game);
}

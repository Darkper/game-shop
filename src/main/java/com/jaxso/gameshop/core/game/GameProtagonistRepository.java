package com.jaxso.gameshop.core.game;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
public interface GameProtagonistRepository {
    void save(GameProtagonist gameProtagonist);

    Optional<GameProtagonist> findById(int id);

    List<GameProtagonist> findAll();

    void remove(GameProtagonist gameProtagonist);
}

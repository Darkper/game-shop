package com.jaxso.gameshop.infrastructure.jpa;

import com.jaxso.gameshop.core.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johny Soto
 */
public interface JpaGameRepository extends JpaRepository<Game, String> {
}

package com.jaxso.gameshop.infrastructure.jpa;

import com.jaxso.gameshop.core.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Johny Soto
 */
public interface JpaGameRepository extends JpaRepository<Game, String> {
    @Query(value = "select game_id from rent_game group by game_id order by sum(quantity) desc limit 1;", nativeQuery = true)
    String getMoreRentedGameId();
}

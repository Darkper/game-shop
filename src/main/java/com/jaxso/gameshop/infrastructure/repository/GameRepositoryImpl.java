package com.jaxso.gameshop.infrastructure.repository;

import com.jaxso.gameshop.core.game.Game;
import com.jaxso.gameshop.core.game.GameReository;
import com.jaxso.gameshop.infrastructure.jpa.JpaGameRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
@Repository
public class GameRepositoryImpl implements GameReository {
    private final JpaGameRepository jpaGameRepository;

    public GameRepositoryImpl(JpaGameRepository jpaGameRepository) {
        this.jpaGameRepository = jpaGameRepository;
    }

    @Override
    public void save(Game game) {
        jpaGameRepository.save(game);
    }

    @Override
    public Optional<Game> findById(String id) {
        return jpaGameRepository.findById(id);
    }

    @Override
    public List<Game> findAll() {
        return jpaGameRepository.findAll();
    }

    @Override
    public void remove(Game game) {
        jpaGameRepository.delete(game);
    }

    @Override
    public String getMoreRentedGameId() {
        return jpaGameRepository.getMoreRentedGameId();
    }
}

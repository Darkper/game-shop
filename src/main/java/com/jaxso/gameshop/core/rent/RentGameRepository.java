package com.jaxso.gameshop.core.rent;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
public interface RentGameRepository {
    void save(RentGame rentGame);

    Optional<RentGame> findById(int id);

    List<RentGame> findAll();

    void remove(RentGame rentGame);
}

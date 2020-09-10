package com.jaxso.gameshop.core.rent;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
public interface RentRepository {
    void save(Rent rent);

    Optional<Rent> findById(int id);

    List<Rent> findAll();

    void remove(Rent rent);
}

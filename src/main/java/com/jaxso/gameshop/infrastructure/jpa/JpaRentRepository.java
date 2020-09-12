package com.jaxso.gameshop.infrastructure.jpa;

import com.jaxso.gameshop.core.rent.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @author Johny Soto
 */
public interface JpaRentRepository extends JpaRepository<Rent, String> {
    List<Rent> getAllByDate(Date date);
}

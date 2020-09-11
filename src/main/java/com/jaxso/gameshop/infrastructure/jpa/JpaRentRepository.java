package com.jaxso.gameshop.infrastructure.jpa;

import com.jaxso.gameshop.core.rent.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johny Soto
 */
public interface JpaRentRepository extends JpaRepository<Rent, String> {
}

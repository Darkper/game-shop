package com.jaxso.gameshop.infrastructure.jpa;

import com.jaxso.gameshop.core.protagonist.Protagonist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johny Soto
 */
public interface JpaProtagonistRepository extends JpaRepository<Protagonist, String> {
}

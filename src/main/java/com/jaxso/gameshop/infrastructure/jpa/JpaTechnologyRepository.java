package com.jaxso.gameshop.infrastructure.jpa;

import com.jaxso.gameshop.core.technology.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johny Soto
 */
public interface JpaTechnologyRepository extends JpaRepository<Technology, String> {
}

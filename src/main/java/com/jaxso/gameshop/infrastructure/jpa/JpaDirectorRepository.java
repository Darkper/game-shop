package com.jaxso.gameshop.infrastructure.jpa;

import com.jaxso.gameshop.core.director.Director;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johny Soto
 */
public interface JpaDirectorRepository extends JpaRepository<Director, String> {
}

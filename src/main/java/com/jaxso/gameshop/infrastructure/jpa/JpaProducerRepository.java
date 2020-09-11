package com.jaxso.gameshop.infrastructure.jpa;

import com.jaxso.gameshop.core.producer.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johny Soto
 */
public interface JpaProducerRepository extends JpaRepository<Producer, String> {
}

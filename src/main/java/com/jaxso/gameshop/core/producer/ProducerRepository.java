package com.jaxso.gameshop.core.producer;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
public interface ProducerRepository {
    void save(Producer producer);

    Optional<Producer> findById(String id);

    List<Producer> findAll();

    void remove(Producer producer);
}

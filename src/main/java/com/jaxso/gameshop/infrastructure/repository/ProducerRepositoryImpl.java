package com.jaxso.gameshop.infrastructure.repository;

import com.jaxso.gameshop.core.producer.Producer;
import com.jaxso.gameshop.core.producer.ProducerRepository;
import com.jaxso.gameshop.infrastructure.jpa.JpaProducerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
@Repository
public class ProducerRepositoryImpl implements ProducerRepository {
    private final JpaProducerRepository jpaProducerRepository;

    public ProducerRepositoryImpl(JpaProducerRepository jpaProducerRepository) {
        this.jpaProducerRepository = jpaProducerRepository;
    }

    @Override
    public void save(Producer producer) {
        jpaProducerRepository.save(producer);
    }

    @Override
    public Optional<Producer> findById(String id) {
        return jpaProducerRepository.findById(id);
    }

    @Override
    public List<Producer> findAll() {
        return jpaProducerRepository.findAll();
    }

    @Override
    public void remove(Producer producer) {
        jpaProducerRepository.delete(producer);
    }
}

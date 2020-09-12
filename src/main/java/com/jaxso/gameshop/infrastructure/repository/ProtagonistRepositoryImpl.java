package com.jaxso.gameshop.infrastructure.repository;

import com.jaxso.gameshop.core.protagonist.Protagonist;
import com.jaxso.gameshop.core.protagonist.ProtagonistRepository;
import com.jaxso.gameshop.infrastructure.jpa.JpaProtagonistRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
@Repository
public class ProtagonistRepositoryImpl implements ProtagonistRepository {
    private final JpaProtagonistRepository jpaProtagonistRepository;

    public ProtagonistRepositoryImpl(JpaProtagonistRepository jpaProtagonistRepository) {
        this.jpaProtagonistRepository = jpaProtagonistRepository;
    }

    @Override
    public void save(Protagonist protagonist) {
        jpaProtagonistRepository.save(protagonist);
    }

    @Override
    public Optional<Protagonist> findById(String id) {
        return jpaProtagonistRepository.findById(id);
    }

    @Override
    public List<Protagonist> findAll() {
        return jpaProtagonistRepository.findAll();
    }

    @Override
    public void remove(Protagonist protagonist) {
        jpaProtagonistRepository.delete(protagonist);
    }
}

package com.jaxso.gameshop.infrastructure.repository;

import com.jaxso.gameshop.core.technology.Technology;
import com.jaxso.gameshop.core.technology.TechnologyRepository;
import com.jaxso.gameshop.infrastructure.jpa.JpaTechnologyRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
public class TechnologyRepositoryImpl implements TechnologyRepository {
    private final JpaTechnologyRepository jpaTechnologyRepository;

    public TechnologyRepositoryImpl(JpaTechnologyRepository jpaTechnologyRepository) {
        this.jpaTechnologyRepository = jpaTechnologyRepository;
    }

    @Override
    public void save(Technology technology) {
        jpaTechnologyRepository.save(technology);
    }

    @Override
    public Optional<Technology> findById(String id) {
        return jpaTechnologyRepository.findById(id);
    }

    @Override
    public List<Technology> findAll() {
        return jpaTechnologyRepository.findAll();
    }

    @Override
    public void remove(Technology technology) {
        jpaTechnologyRepository.delete(technology);
    }
}

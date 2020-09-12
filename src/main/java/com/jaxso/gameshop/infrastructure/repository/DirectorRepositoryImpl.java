package com.jaxso.gameshop.infrastructure.repository;

import com.jaxso.gameshop.core.director.Director;
import com.jaxso.gameshop.core.director.DirectorRepository;
import com.jaxso.gameshop.infrastructure.jpa.JpaDirectorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
@Repository
public class DirectorRepositoryImpl implements DirectorRepository {

    private final JpaDirectorRepository jpaDirectorRepository;

    public DirectorRepositoryImpl(JpaDirectorRepository jpaDirectorRepository) {
        this.jpaDirectorRepository = jpaDirectorRepository;
    }


    @Override
    public void save(Director director) {
        jpaDirectorRepository.save(director);
    }

    @Override
    public Optional<Director> findById(String id) {
        return jpaDirectorRepository.findById(id);
    }

    @Override
    public List<Director> findAll() {
        return jpaDirectorRepository.findAll();
    }

    @Override
    public void remove(Director director) {
        jpaDirectorRepository.delete(director);
    }
}

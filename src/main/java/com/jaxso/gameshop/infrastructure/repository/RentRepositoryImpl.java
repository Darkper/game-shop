package com.jaxso.gameshop.infrastructure.repository;

import com.jaxso.gameshop.core.rent.Rent;
import com.jaxso.gameshop.core.rent.RentRepository;
import com.jaxso.gameshop.infrastructure.jpa.JpaRentRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Johny Soto
 */
@Repository
public class RentRepositoryImpl implements RentRepository {
    private final JpaRentRepository jpaRentRepository;

    public RentRepositoryImpl(JpaRentRepository jpaRentRepository) {
        this.jpaRentRepository = jpaRentRepository;
    }

    @Override
    public void save(Rent rent) {
        jpaRentRepository.save(rent);
    }

    @Override
    public Optional<Rent> findById(String id) {
        return jpaRentRepository.findById(id);
    }

    @Override
    public List<Rent> findAll() {
        return jpaRentRepository.findAll();
    }

    @Override
    public void remove(Rent rent) {
        jpaRentRepository.delete(rent);
    }

    @Override
    public List<Rent> getAllByDate(Date date) {
        return jpaRentRepository.getAllByDate(date);
    }
}

package com.jaxso.gameshop.api;

import com.jaxso.gameshop.application.data.RentData;
import com.jaxso.gameshop.core.rent.Rent;
import com.jaxso.gameshop.infrastructure.repository.RentRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Johny Soto
 */
@Slf4j
@RestController
@RequestMapping(path = "/rents")
public class RentApi {
    private final RentRepositoryImpl rentRepository;

    public RentApi(RentRepositoryImpl rentRepository) {
        this.rentRepository = rentRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(rentRepository.findAll().stream().map(Rent::toData).collect(Collectors.toList()));
        } catch (Exception e) {
            log.error("Failed to get rents: ".concat(e.getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Rent> optionalRent = rentRepository.findById(id);
        if (optionalRent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Rent not found");
        }
        return ResponseEntity.ok(optionalRent.get().toData());
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid RentData rent) {
        rentRepository.save(rent.toRent());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody @Valid RentData rent) {
        Optional<Rent> optionalRent = rentRepository.findById(rent.getId());
        if (optionalRent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Rent not found");
        }
        rentRepository.remove(optionalRent.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Rent rent) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }
}

package com.jaxso.gameshop.api;

import com.jaxso.gameshop.core.producer.Producer;
import com.jaxso.gameshop.infrastructure.repository.ProducerRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Johny Soto
 */
@Slf4j
@RestController
@RequestMapping(path = "/producers")
public class ProducerApi {

    private final ProducerRepositoryImpl producerRepository;

    public ProducerApi(ProducerRepositoryImpl producerRepository) {
        this.producerRepository = producerRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(producerRepository.findAll());

    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Producer> optionalProducer = producerRepository.findById(id);
        if (optionalProducer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Producer not found");
        }
        return ResponseEntity.ok(optionalProducer.get());
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Producer producer) {
        producerRepository.save(producer);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody @Valid Producer producer) {
        Optional<Producer> optionalProducer = producerRepository.findById(producer.getId());
        if (optionalProducer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Producer not found");
        }
        try {
            producerRepository.remove(optionalProducer.get());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Foreign key violation");
        }
        return ResponseEntity.noContent().build();

    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Producer producer) {
        return save(producer);
    }
}

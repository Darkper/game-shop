package com.jaxso.gameshop.api;

import com.jaxso.gameshop.core.protagonist.Protagonist;
import com.jaxso.gameshop.infrastructure.repository.ProtagonistRepositoryImpl;
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
@RequestMapping(path = "/protagonists")
public class ProtagonistApi {
    private final ProtagonistRepositoryImpl protagonistRepository;

    public ProtagonistApi(ProtagonistRepositoryImpl protagonistRepository) {
        this.protagonistRepository = protagonistRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(protagonistRepository.findAll());

    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Protagonist> optionalProtagonist = protagonistRepository.findById(id);
        if (optionalProtagonist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Protagonist not found");
        }
        return ResponseEntity.ok(optionalProtagonist.get());
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Protagonist protagonist) {
        protagonistRepository.save(protagonist);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody @Valid Protagonist protagonist) {
        Optional<Protagonist> optionalProtagonist = protagonistRepository.findById(protagonist.getId());
        if (optionalProtagonist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Protagonist not found");
        }
        try {
            protagonistRepository.remove(optionalProtagonist.get());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Foreign key violation");
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Protagonist protagonist) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
    }
}

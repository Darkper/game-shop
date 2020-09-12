package com.jaxso.gameshop.api;

import com.jaxso.gameshop.core.technology.Technology;
import com.jaxso.gameshop.infrastructure.repository.TechnologyRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping(path = "/technologies")
public class TechnologyApi {
    private final TechnologyRepositoryImpl technologyRepository;

    public TechnologyApi(TechnologyRepositoryImpl technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(technologyRepository.findAll());
        } catch (Exception e) {
            log.error("Failed to get technologies: ".concat(e.getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Technology> optionalTechnology = technologyRepository.findById(id);
        if (optionalTechnology.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Technology not found");
        }
        return ResponseEntity.ok(optionalTechnology.get());
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Technology technology) {
        technologyRepository.save(technology);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody @Valid Technology technology) {
        Optional<Technology> optionalTechnology = technologyRepository.findById(technology.getId());
        if (optionalTechnology.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Technology not found");
        }
        technologyRepository.remove(optionalTechnology.get());
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Technology technology) {
        return save(technology);
    }
}

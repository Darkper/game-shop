package com.jaxso.gameshop.api;

import com.jaxso.gameshop.core.director.Director;
import com.jaxso.gameshop.infrastructure.repository.DirectorRepositoryImpl;
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
@RequestMapping(path = "/directors")
public class DirectorApi {
    private final DirectorRepositoryImpl directorRepository;

    public DirectorApi(DirectorRepositoryImpl directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(directorRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Director> optionalDirector = directorRepository.findById(id);
        if (optionalDirector.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Director not found");
        }
        return ResponseEntity.ok(optionalDirector.get());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Director director) {
        directorRepository.save(director);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody @Valid Director director) {
        Optional<Director> optionalDirector = directorRepository.findById(director.getId());
        if (optionalDirector.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Director not found");
        }
        try {
            directorRepository.remove(optionalDirector.get());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Foreign key violation");
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Director director) {
        return save(director);
    }
}

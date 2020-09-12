package com.jaxso.gameshop.api;

import com.jaxso.gameshop.core.client.Client;
import com.jaxso.gameshop.infrastructure.repository.ClientRepositoryImpl;
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
@RequestMapping(path = "/clients")
public class ClientApi {

    private final ClientRepositoryImpl clientRepository;

    public ClientApi(ClientRepositoryImpl clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @GetMapping("{document}")
    public ResponseEntity<?> findById(@PathVariable String document) {
        Optional<Client> optionalClient = clientRepository.findById(document);
        if (optionalClient.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Client not found");
        }
        return ResponseEntity.ok(optionalClient.get());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid Client client) {
        clientRepository.save(client);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody @Valid Client client) {
        Optional<Client> optionalClient = clientRepository.findById(client.getDocument());
        if (optionalClient.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Client not found");
        }
        try {
            clientRepository.remove(optionalClient.get());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Foreign key violation");
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Client client) {
        return save(client);
    }
}

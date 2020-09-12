package com.jaxso.gameshop.api;

import com.jaxso.gameshop.application.data.GameData;
import com.jaxso.gameshop.core.game.Game;
import com.jaxso.gameshop.infrastructure.repository.GameRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
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
@RequestMapping(path = "/games")
public class GameApi {

    private final GameRepositoryImpl gameRepository;

    public GameApi(GameRepositoryImpl gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(gameRepository.findAll().stream().map(Game::toData).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Game not found");
        }
        return ResponseEntity.ok(optionalGame.get().toData());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid GameData gameData) {
        gameRepository.save(gameData.toGame());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody @Valid GameData game) {
        Optional<Game> optionalGame = gameRepository.findById(game.getId());
        if (optionalGame.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Game not found");
        }
        try {
            gameRepository.remove(optionalGame.get());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Foreign key violation");
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid GameData game) {
        return save(game);
    }
}

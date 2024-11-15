package com.devsuperior.dslist.controller;

import com.devsuperior.dslist.dto.GameFullTO;
import com.devsuperior.dslist.dto.GameTO;
import com.devsuperior.dslist.exception.GameNotFound;
import com.devsuperior.dslist.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequestMapping("/games")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameTO>> findAll() {
        List<GameTO> games = gameService.allGames();
        return games.isEmpty() ?
                new ResponseEntity<>(List.of(), HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameFullTO> gamePorId(@PathVariable("id") Long id) {
        GameFullTO gameTO = gameService.gameById(id);
        return new ResponseEntity<>(gameTO, HttpStatus.OK);
    }

    @ExceptionHandler(GameNotFound.class)
    public ResponseEntity<Void> handleGameNotFound(GameNotFound ex) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Void> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

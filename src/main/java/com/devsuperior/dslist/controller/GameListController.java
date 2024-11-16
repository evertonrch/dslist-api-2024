package com.devsuperior.dslist.controller;

import com.devsuperior.dslist.dto.GameListTO;
import com.devsuperior.dslist.dto.GameTO;
import com.devsuperior.dslist.dto.ReplacementTO;
import com.devsuperior.dslist.exception.GameListNotFoundException;
import com.devsuperior.dslist.exception.InvalidPositionException;
import com.devsuperior.dslist.service.GameListService;
import com.devsuperior.dslist.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
@AllArgsConstructor
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListTO>> getAllGameList() {
        var gameLists = gameListService.allGameList();
        return gameLists.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(gameLists);
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameTO>> findByList(@PathVariable("listId") Long id) {
        List<GameTO> games = gameService.findByList(id);
        return games.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(games);
    }

    @PostMapping("/{listId}/replacement")
    public ResponseEntity<Void> move(@PathVariable Long listId, @RequestBody ReplacementTO request) {
        gameListService.move(listId, request.sourceIndex(), request.destinationIndex());
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @ExceptionHandler(GameListNotFoundException.class)
    public ResponseEntity<Void> handleGameListNotFound(GameListNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(InvalidPositionException.class)
    public ResponseEntity<Void> handleInvalidPositionException(InvalidPositionException ex) {
        return ResponseEntity.badRequest().build();
    }
}

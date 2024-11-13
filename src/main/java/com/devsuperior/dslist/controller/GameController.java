package com.devsuperior.dslist.controller;

import com.devsuperior.dslist.dto.GameTO;
import com.devsuperior.dslist.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

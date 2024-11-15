package com.devsuperior.dslist.controller;

import com.devsuperior.dslist.dto.GameListTO;
import com.devsuperior.dslist.service.GameListService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
@AllArgsConstructor
public class GameListController {

    private final GameListService gameListService;

    @GetMapping
    public ResponseEntity<List<GameListTO>> getAllGameList() {
        var gameLists = gameListService.allGameList();
        return gameLists.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(gameLists);
    }
}

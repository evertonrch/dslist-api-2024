package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameFullTO;
import com.devsuperior.dslist.dto.GameTO;
import com.devsuperior.dslist.entity.Game;
import com.devsuperior.dslist.exception.GameNotFound;
import com.devsuperior.dslist.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameTO> allGames() {
        return gameRepository.findAll()
                .stream()
                .map(GameTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public GameFullTO gameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFound("Game não encontrado."));

        return new GameFullTO(game);
    }
}

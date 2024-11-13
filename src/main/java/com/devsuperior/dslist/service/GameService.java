package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameTO;
import com.devsuperior.dslist.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public List<GameTO> allGames() {
        return gameRepository.findAll()
                .stream()
                .map(GameTO::new)
                .toList();
    }
}

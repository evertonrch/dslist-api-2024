package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameListTO;
import com.devsuperior.dslist.repository.GameListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameListService {

    private final GameListRepository gameListRepository;

    public List<GameListTO> allGameList() {
        return gameListRepository.findAll().stream()
                .map(GameListTO::new)
                .toList();
    }
}

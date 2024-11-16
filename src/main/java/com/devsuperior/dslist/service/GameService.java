package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameFullTO;
import com.devsuperior.dslist.dto.GameTO;
import com.devsuperior.dslist.entity.Game;
import com.devsuperior.dslist.entity.GameList;
import com.devsuperior.dslist.exception.GameListNotFoundException;
import com.devsuperior.dslist.exception.GameNotFoundException;
import com.devsuperior.dslist.repository.GameListRepository;
import com.devsuperior.dslist.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final GameListRepository gameListRepository;

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
                .orElseThrow(() -> new GameNotFoundException("Game não encontrado."));

        return new GameFullTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameTO> findByList(Long listId) {
        // validar se existe a lista
        GameList gameList = gameListPorId(listId);

        return gameRepository.searchByList(gameList.getId()).stream()
                .map(GameTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    private GameList gameListPorId(Long listId) {
        return gameListRepository.findById(listId)
                .orElseThrow(() -> new GameListNotFoundException("Tipo de lista não existe."));
    }
}

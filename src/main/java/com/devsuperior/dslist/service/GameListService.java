package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameListTO;
import com.devsuperior.dslist.projection.GameProjection;
import com.devsuperior.dslist.repository.GameListRepository;
import com.devsuperior.dslist.repository.GameRepository;
import com.devsuperior.dslist.validator.DestinationPositionValidator;
import com.devsuperior.dslist.validator.SourcePositionValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GameListService {

    private final GameListRepository gameListRepository;
    private final GameRepository gameRepository;
    private final SourcePositionValidator sourcePositionValidator;
    private final DestinationPositionValidator destinationPositionValidator;

    public List<GameListTO> allGameList() {
        return gameListRepository.findAll().stream()
                .map(GameListTO::new)
                .toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        sourcePositionValidator.validate(sourceIndex);
        destinationPositionValidator.validate(destinationIndex);

        List<GameProjection> list = gameRepository.searchByList(listId);
        GameProjection removed = list.remove(sourceIndex);
        list.add(destinationIndex, removed);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++)
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
    }
}

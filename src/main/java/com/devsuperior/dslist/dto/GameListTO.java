package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entity.GameList;

public record GameListTO(Long id, String name) {
        public GameListTO(GameList entity) {
        this(entity.getId(), entity.getName());
    }
}

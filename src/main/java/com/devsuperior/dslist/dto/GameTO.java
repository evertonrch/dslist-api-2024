package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entity.Game;

public record GameTO(Long id, String title, Integer year, String imgUrl, String shortDescription) {

    public GameTO(Game game) {
        this(game.getId(), game.getTitle(), game.getYear(), game.getImgUrl(), game.getShortDescription());
    }
}

package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entity.Game;
import com.devsuperior.dslist.projection.GameProjection;

public record GameTO(Long id, String title, Integer year, String imgUrl, String shortDescription) {

    public GameTO(Game game) {
        this(game.getId(), game.getTitle(), game.getYear(), game.getImgUrl(), game.getShortDescription());
    }

    public GameTO(GameProjection projection) {
        this(projection.getId(), projection.getTitle(), projection.getYear(), projection.getImgUrl(), projection.getShortDescription());
    }
}

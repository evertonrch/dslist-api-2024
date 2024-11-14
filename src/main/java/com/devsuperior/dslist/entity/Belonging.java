package com.devsuperior.dslist.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_belonging")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Belonging {

    @EmbeddedId
    private BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging(Integer position, Game game, GameList gameList) {
        this.position = position;
        id.setGame(game);
        id.setGameList(gameList);
    }
}

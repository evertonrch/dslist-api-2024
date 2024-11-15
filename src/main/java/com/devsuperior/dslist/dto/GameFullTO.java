package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entity.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class GameFullTO {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameFullTO(Game game) {
        BeanUtils.copyProperties(game, this);
    }
}


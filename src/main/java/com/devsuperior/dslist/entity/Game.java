package com.devsuperior.dslist.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_game")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String title;

    @Column(name = "game_year") // palavra reservada no banco
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;

    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescription;
}

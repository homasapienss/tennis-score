package edu.tennis.score.homasapienss.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "matches")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "player_1")
    private int player1;

    @Column(name = "player_2")
    private int player2;

    @Column(name = "winner")
    private int winner;
}

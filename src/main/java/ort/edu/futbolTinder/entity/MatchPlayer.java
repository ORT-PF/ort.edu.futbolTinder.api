package ort.edu.futbolTinder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PARTIDO_JUGADORES")
public class MatchPlayer extends AppEntity {

    @Column(name = "PLAYER_ID", nullable = false)
    private Long playerId;

    @ManyToOne
    @JoinColumn(name = "MATCH_ID", nullable = false)
    private Match match;
}

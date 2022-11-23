package ort.edu.futbolTinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ort.edu.futbolTinder.entity.MatchPlayer;

public interface MatchPlayerRepository extends JpaRepository<MatchPlayer, Long> {
    void deleteByPlayerIdAndMatch_Id(Long playerId, Long matchId);
}

package ort.edu.futbolTinder.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ort.edu.futbolTinder.entity.Match;
import ort.edu.futbolTinder.entity.MatchPlayer;
import ort.edu.futbolTinder.error.MatchDoesntExistException;
import ort.edu.futbolTinder.error.PlayerAlreadyJoinedException;
import ort.edu.futbolTinder.error.QuotaExceededException;
import ort.edu.futbolTinder.repository.MatchPlayerRepository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Service
public class MatchPlayerService {
    private final MatchService matchService;
    private final EntityManager entityManager;
    private final MatchPlayerRepository matchPlayerRepository;

    public Long joinPlayer(Long playerId, Long matchId) throws Exception {
        if (!matchService.exists(matchId)) {
            throw new MatchDoesntExistException(matchId);
        }
        if (matchService.alreadyJoinedOrHost(playerId, matchId)) {
            throw new PlayerAlreadyJoinedException(playerId, matchId);
        }
        if (!matchService.hasRemainingQuota(matchId)) {
            throw new QuotaExceededException(matchId);
        }
        return matchPlayerRepository.save(createMatchPlayer(playerId, matchId)).getId();
    }

    private MatchPlayer createMatchPlayer(Long playerId, Long matchId) {
        MatchPlayer matchPlayer = new MatchPlayer();
        matchPlayer.setPlayerId(playerId);
        matchPlayer.setMatch(entityManager.getReference(Match.class, matchId));
        return matchPlayer;
    }

    public void clear() {
        matchPlayerRepository.deleteAll();
    }

    public void leave(Long playerId, Long matchId) {
        matchPlayerRepository.deleteByPlayerIdAndMatch_Id(playerId, matchId);
    }
}

package ort.edu.futbolTinder.error;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlayerAlreadyJoinedException extends Exception {
    private final Long playerId;
    private final Long matchId;

    @Override
    public String getLocalizedMessage() {
        return "El jugador con ID " + playerId + " ya se ha unido al partido con ID " + matchId;
    }
}

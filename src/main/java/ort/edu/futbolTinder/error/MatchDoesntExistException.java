package ort.edu.futbolTinder.error;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MatchDoesntExistException extends Exception {
    private final Long matchId;

    @Override
    public String getLocalizedMessage() {
        return "El partido con ID " + matchId + " no existe";
    }
}

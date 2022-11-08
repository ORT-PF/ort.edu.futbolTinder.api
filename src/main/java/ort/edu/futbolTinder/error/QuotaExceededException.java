package ort.edu.futbolTinder.error;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QuotaExceededException extends Exception {
    private final Long matchId;

    @Override
    public String getLocalizedMessage() {
        return "Al partido con ID " + matchId + " no le restan cupos";
    }
}

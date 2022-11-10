package ort.edu.futbolTinder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ort.edu.futbolTinder.service.MatchPlayerService;

@RestController
@RequestMapping("/jugador")
public class MatchPlayerController {

    private final MatchPlayerService matchPlayerService;

    public MatchPlayerController(MatchPlayerService matchPlayerService) {
        this.matchPlayerService = matchPlayerService;
    }

    @PostMapping("/unirse")
    public ResponseEntity<Long> matchCandidates(@RequestParam Long playerId,
                                                @RequestParam Long matchId) throws Exception {
        return new ResponseEntity<>(matchPlayerService.joinPlayer(playerId, matchId), HttpStatus.OK);
    }
}

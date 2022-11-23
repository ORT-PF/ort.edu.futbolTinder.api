package ort.edu.futbolTinder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("/clear")
    public ResponseEntity<Void> clear() {
        matchPlayerService.clear();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

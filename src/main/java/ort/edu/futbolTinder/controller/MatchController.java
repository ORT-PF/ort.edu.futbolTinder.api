package ort.edu.futbolTinder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ort.edu.futbolTinder.dto.request.MatchRequestDTO;
import ort.edu.futbolTinder.dto.response.MatchCandidateDTO;
import ort.edu.futbolTinder.dto.response.MatchDTO;
import ort.edu.futbolTinder.service.MatchService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partidos")
public class MatchController extends CRUDController<MatchDTO, MatchRequestDTO> {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        super(matchService);
        this.matchService = matchService;
    }

    @GetMapping("/matchCandidates")
    public ResponseEntity<List<MatchCandidateDTO>> matchCandidates(@RequestParam Double latitude,
                                                                   @RequestParam Double longitude,
                                                                   @RequestParam Long playerId,
                                                                   @RequestParam Optional<Double> distance,
                                                                   @RequestParam Optional<Integer> days) {
        return new ResponseEntity<>(matchService.matchCandidates(
                latitude,
                longitude,
                playerId,
                distance.orElse(5d),
                days.orElse(7)
        ), HttpStatus.OK);

    }

    @GetMapping("/joinedMatches/{playerId}")
    public ResponseEntity<List<MatchDTO>> joinedMatches(@PathVariable Long playerId) {
        return new ResponseEntity<>(matchService.joinedMatches(playerId), HttpStatus.OK);
    }

    @DeleteMapping("/clear_old")
    public ResponseEntity<Void> clearOld() {
        matchService.clearOld();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

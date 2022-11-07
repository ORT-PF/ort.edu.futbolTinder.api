package ort.edu.futbolTinder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ort.edu.futbolTinder.dto.request.PartidoRequestDTO;
import ort.edu.futbolTinder.dto.response.MatchCandidateDTO;
import ort.edu.futbolTinder.dto.response.PartidoDTO;
import ort.edu.futbolTinder.service.PartidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partidos")
public class PartidoController extends CRUDController<PartidoDTO, PartidoRequestDTO> {

    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        super(partidoService);
        this.partidoService = partidoService;
    }

    @GetMapping("/matchCandidates")
    public ResponseEntity<List<MatchCandidateDTO>> matchCandidates(@RequestParam Double latitude,
                                                                   @RequestParam Double longitude,
                                                                   @RequestParam Long playerId,
                                                                   @RequestParam Optional<Double> distance,
                                                                   @RequestParam Optional<Integer> days) {
        return new ResponseEntity<>(partidoService.matchCandidates(
                latitude,
                longitude,
                playerId,
                distance.orElse(5d),
                days.orElse(7)
        ), HttpStatus.OK);
    }
}

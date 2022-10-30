package ort.edu.futbolTinder.partido.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ort.edu.futbolTinder.generic.controller.CRUDController;
import ort.edu.futbolTinder.partido.dto.request.PartidoRequestDTO;
import ort.edu.futbolTinder.partido.dto.response.PartidoDTO;
import ort.edu.futbolTinder.partido.service.PartidoService;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController extends CRUDController<PartidoDTO, PartidoRequestDTO> {

    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        super(partidoService);
        this.partidoService = partidoService;
    }

    @GetMapping
    public ResponseEntity<List<PartidoDTO>> match(@RequestParam double longitude, @RequestParam double latitude) {
        return new ResponseEntity<>(partidoService.findMatchCandidates(longitude, latitude), HttpStatus.OK);
    }
}

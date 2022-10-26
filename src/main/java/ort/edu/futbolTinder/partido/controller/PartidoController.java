package ort.edu.futbolTinder.partido.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ort.edu.futbolTinder.generic.controller.CRUDController;
import ort.edu.futbolTinder.partido.dto.request.MatchRequestDTO;
import ort.edu.futbolTinder.partido.dto.request.PartidoRequestDTO;
import ort.edu.futbolTinder.partido.dto.response.PartidoDTO;
import ort.edu.futbolTinder.partido.service.PartidoService;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController extends CRUDController<PartidoDTO, PartidoRequestDTO> {
    public PartidoController(PartidoService crudService) {
        super(crudService);
    }

    @GetMapping("/match")
    public ResponseEntity<List<PartidoDTO>> match(MatchRequestDTO matchRequestDTO){
        return super.getAll(null);
    }
}

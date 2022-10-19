package ort.edu.futbolTinder.partido.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ort.edu.futbolTinder.generic.controller.CRUDController;
import ort.edu.futbolTinder.generic.service.CRUDService;
import ort.edu.futbolTinder.partido.dto.request.PartidoRequestDTO;
import ort.edu.futbolTinder.partido.dto.response.PartidoDTO;
import ort.edu.futbolTinder.partido.service.PartidoService;

@RestController
@RequestMapping("/partidos")
public class PartidoController extends CRUDController<PartidoDTO, PartidoRequestDTO> {
    public PartidoController(PartidoService crudService) {
        super(crudService);
    }
}

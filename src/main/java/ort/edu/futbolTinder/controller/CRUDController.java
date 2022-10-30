package ort.edu.futbolTinder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ort.edu.futbolTinder.service.CRUDService;

import java.util.List;

@RequiredArgsConstructor
public abstract class CRUDController<DTO, RequestDTO> {

    protected final CRUDService<DTO, ?, RequestDTO> crudService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DTO>> getAll(@RequestParam(required = false) String sort) {
        return new ResponseEntity<>(crudService.getAll(sort), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DTO> get(@PathVariable Long id) {
        return new ResponseEntity<>(crudService.get(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Long> add(@RequestBody RequestDTO requestDTO) throws Exception {
        return new ResponseEntity<>(crudService.add(requestDTO), HttpStatus.OK);
    }

    @PostMapping("/addAll")
    public ResponseEntity<List<Long>> addAll(@RequestBody List<RequestDTO> requestDTOs) throws Exception {
        return new ResponseEntity<>(crudService.addAll(requestDTOs), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<>(crudService.update(id, requestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return new ResponseEntity<>(crudService.delete(id), HttpStatus.OK);
    }
}

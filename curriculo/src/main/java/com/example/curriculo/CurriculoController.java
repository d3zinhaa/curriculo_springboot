package com.example.curriculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.Data;
import java.util.List;

@Data
@RestController
@RequestMapping("/api/curriculo")
public class CurriculoController {
 
    private final CurriculoService curriculoService;
 
    @Autowired
    public CurriculoController(CurriculoService curriculoService) {
        this.curriculoService = curriculoService;
    }
 
    @GetMapping
    public ResponseEntity<List<Curriculo>> getAllCurriculos() {
        List<Curriculo> curriculos = curriculoService.getAllCurriculos();
        return new ResponseEntity<>(curriculos, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> getCurriculoById(@PathVariable Long id) {
        return curriculoService.getCurriculoById(id)
                .map(curriculo -> new ResponseEntity<>(curriculo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
 
    @PostMapping
    public ResponseEntity<Curriculo> addCurriculo(@RequestBody Curriculo curriculo) {
        Curriculo savedCurriculo = curriculoService.addCurriculo(curriculo);
        return new ResponseEntity<>(savedCurriculo, HttpStatus.CREATED);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Curriculo> updateCurriculo(@PathVariable Long id, @RequestBody Curriculo updatedCurriculo) {
        return curriculoService.updateCurriculo(id, updatedCurriculo)
                .map(curriculo -> new ResponseEntity<>(curriculo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculo(@PathVariable Long id) {
        boolean deleted = curriculoService.deleteCurriculo(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
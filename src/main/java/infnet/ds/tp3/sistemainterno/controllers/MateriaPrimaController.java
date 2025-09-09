package infnet.ds.tp3.sistemainterno.controllers;

import infnet.ds.tp3.sistemainterno.models.MateriaPrima;
import infnet.ds.tp3.sistemainterno.models.MateriaPrima;
import infnet.ds.tp3.sistemainterno.services.MateriaPrimaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materia-prima")
public class MateriaPrimaController {
    private final MateriaPrimaService materiaPrimaService;

    public MateriaPrimaController(MateriaPrimaService materiaPrimaService) {
        this.materiaPrimaService = materiaPrimaService;
    }

    @PostMapping
    public ResponseEntity<MateriaPrima> createMateriaPrima(@RequestBody MateriaPrima materiaPrima) {
        MateriaPrima materiaPrimaSalvo = materiaPrimaService.createMateriaPrima(materiaPrima);

        return ResponseEntity.status(HttpStatus.CREATED).body(materiaPrimaSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaPrima> readMateriaPrima(@PathVariable long id) {
        Optional<MateriaPrima> result = materiaPrimaService.findMateriaPrima(id);
        MateriaPrima materiaPrima = null;

        if (result.isPresent()) {
            materiaPrima = result.get();
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(materiaPrima);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaPrima> updateMateriaPrima(@PathVariable long id, @RequestBody MateriaPrima materiaPrimaAtualizado) {
        MateriaPrima materiaPrima = materiaPrimaService.updateMateriaPrima(id, materiaPrimaAtualizado);

        return ResponseEntity.ok().body(materiaPrima);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MateriaPrima> deleteMateriaPrima(@PathVariable long id) {
        materiaPrimaService.deleteMateriaPrima(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<MateriaPrima>> readMateriaPrimas() {
        ArrayList<MateriaPrima> materiaPrimas = materiaPrimaService.findAllMateriaPrimas();

        return ResponseEntity.status(HttpStatus.FOUND).body(materiaPrimas);
    }
}

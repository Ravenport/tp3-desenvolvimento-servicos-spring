package infnet.ds.tp3.sistemainterno.controllers;

import infnet.ds.tp3.sistemainterno.models.Fornecedor;
import infnet.ds.tp3.sistemainterno.models.Fornecedor;
import infnet.ds.tp3.sistemainterno.services.FornecedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorSalvo = fornecedorService.createFornecedor(fornecedor);

        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> readFornecedor(@PathVariable long id) {
        Optional<Fornecedor> result = fornecedorService.findFornecedor(id);
        Fornecedor fornecedor = null;

        if (result.isPresent()) {
            fornecedor = result.get();
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable long id, @RequestBody Fornecedor fornecedorAtualizado) {
        Fornecedor fornecedor = fornecedorService.updateFornecedor(id, fornecedorAtualizado);

        return ResponseEntity.ok().body(fornecedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fornecedor> deleteFornecedor(@PathVariable long id) {
        fornecedorService.deleteFornecedor(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> readFornecedors() {
        ArrayList<Fornecedor> fornecedores = fornecedorService.findAllFornecedores();

        return ResponseEntity.status(HttpStatus.FOUND).body(fornecedores);
    }
}

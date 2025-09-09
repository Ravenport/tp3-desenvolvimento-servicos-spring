package infnet.ds.tp3.sistemainterno.controllers;

import infnet.ds.tp3.sistemainterno.models.Funcionario;
import infnet.ds.tp3.sistemainterno.models.Funcionario;
import infnet.ds.tp3.sistemainterno.services.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioSalvo = funcionarioService.createFuncionario(funcionario);

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> readFuncionario(@PathVariable long id) {
        Optional<Funcionario> result = funcionarioService.findFuncionario(id);
        Funcionario funcionario = null;

        if (result.isPresent()) {
            funcionario = result.get();
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable long id, @RequestBody Funcionario funcionarioAtualizado) {
        Funcionario funcionario = funcionarioService.updateFuncionario(id, funcionarioAtualizado);

        return ResponseEntity.ok().body(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable long id) {
        funcionarioService.deleteFuncionario(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> readFuncionarios() {
        ArrayList<Funcionario> funcionarios = funcionarioService.findAllFuncionarios();

        return ResponseEntity.status(HttpStatus.FOUND).body(funcionarios);
    }
}

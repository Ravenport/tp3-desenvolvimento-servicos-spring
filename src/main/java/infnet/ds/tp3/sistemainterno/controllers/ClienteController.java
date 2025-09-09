package infnet.ds.tp3.sistemainterno.controllers;

import infnet.ds.tp3.sistemainterno.models.Cliente;
import infnet.ds.tp3.sistemainterno.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.createCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> readCliente(@PathVariable long id) {
        Optional<Cliente> result = clienteService.findCliente(id);
        Cliente cliente = null;

        if (result.isPresent()) {
            cliente = result.get();
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable long id, @RequestBody Cliente clienteAtualizado) {
        Cliente cliente = clienteService.updateCliente(id, clienteAtualizado);

        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable long id) {
        clienteService.deleteCliente(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> readClientes() {
        ArrayList<Cliente> clientes = clienteService.findAllClientes();

        return ResponseEntity.status(HttpStatus.FOUND).body(clientes);
    }
}

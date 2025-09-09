package infnet.ds.tp3.sistemainterno.services;

import infnet.ds.tp3.sistemainterno.models.Cliente;
import infnet.ds.tp3.sistemainterno.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente createCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    public Optional<Cliente> findCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente updateCliente(Long id, Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository.findById(id).get();

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setTelefone(clienteAtualizado.getTelefone());

        clienteRepository.save(cliente);
        return cliente;
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public ArrayList<Cliente> findAllClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clienteRepository.findAll().forEach(clientes::add);

        return clientes;
    }
}

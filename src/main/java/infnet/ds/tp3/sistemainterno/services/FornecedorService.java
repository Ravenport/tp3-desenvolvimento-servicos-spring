package infnet.ds.tp3.sistemainterno.services;

import infnet.ds.tp3.sistemainterno.models.Fornecedor;
import infnet.ds.tp3.sistemainterno.repositories.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor createFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
        return fornecedor;
    }

    public Optional<Fornecedor> findFornecedor(Long id) {
        return fornecedorRepository.findById(id);
    }

    public Fornecedor updateFornecedor(Long id, Fornecedor fornecedorAtualizado) {
        Fornecedor fornecedor = fornecedorRepository.findById(id).get();

        fornecedor.setNome(fornecedorAtualizado.getNome());
        fornecedor.setEmail(fornecedorAtualizado.getEmail());
        fornecedor.setTelefone(fornecedorAtualizado.getTelefone());
        fornecedor.setRazaoSocial(fornecedorAtualizado.getRazaoSocial());
        fornecedor.setTipoFornecedor(fornecedorAtualizado.getTipoFornecedor());

        fornecedorRepository.save(fornecedor);
        return fornecedor;
    }

    public void deleteFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }

    public ArrayList<Fornecedor> findAllFornecedores() {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        fornecedorRepository.findAll().forEach(fornecedores::add);

        return fornecedores;
    }
}

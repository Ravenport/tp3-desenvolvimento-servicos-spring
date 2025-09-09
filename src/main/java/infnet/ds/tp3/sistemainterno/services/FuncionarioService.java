package infnet.ds.tp3.sistemainterno.services;

import infnet.ds.tp3.sistemainterno.models.Funcionario;
import infnet.ds.tp3.sistemainterno.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    public Optional<Funcionario> findFuncionario(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario updateFuncionario(Long id, Funcionario funcionarioAtualizado) {
        Funcionario funcionario = funcionarioRepository.findById(id).get();

        funcionario.setNome(funcionarioAtualizado.getNome());
        funcionario.setEmail(funcionarioAtualizado.getEmail());
        funcionario.setTelefone(funcionarioAtualizado.getTelefone());
        funcionario.setCargo(funcionarioAtualizado.getCargo());
        funcionario.setSetor(funcionarioAtualizado.getSetor());
        funcionario.setDocumentoIdentificacao(funcionarioAtualizado.getDocumentoIdentificacao());
        funcionario.setTipoDocumento(funcionarioAtualizado.getTipoDocumento());

        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    public void deleteFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public ArrayList<Funcionario> findAllFuncionarios() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarioRepository.findAll().forEach(funcionarios::add);

        return funcionarios;
    }
}

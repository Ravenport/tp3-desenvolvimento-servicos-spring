package infnet.ds.tp3.sistemainterno.services;

import infnet.ds.tp3.sistemainterno.models.MateriaPrima;
import infnet.ds.tp3.sistemainterno.repositories.MateriaPrimaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaPrimaService {
    private final MateriaPrimaRepository materiaPrimaRepository;

    public MateriaPrimaService(MateriaPrimaRepository materiaPrimaRepository) {
        this.materiaPrimaRepository = materiaPrimaRepository;
    }

    public MateriaPrima createMateriaPrima(MateriaPrima materiaPrima) {
        materiaPrimaRepository.save(materiaPrima);
        return materiaPrima;
    }

    public Optional<MateriaPrima> findMateriaPrima(Long id) {
        return materiaPrimaRepository.findById(id);
    }

    public MateriaPrima updateMateriaPrima(Long id, MateriaPrima materiaPrimaAtualizado) {
        MateriaPrima materiaPrima = materiaPrimaRepository.findById(id).get();

        materiaPrima.setNome(materiaPrimaAtualizado.getNome());
        materiaPrima.setDescricao(materiaPrimaAtualizado.getDescricao());

        materiaPrimaRepository.save(materiaPrima);
        return materiaPrima;
    }

    public void deleteMateriaPrima(Long id) {
        materiaPrimaRepository.deleteById(id);
    }

    public ArrayList<MateriaPrima> findAllMateriaPrimas() {
        ArrayList<MateriaPrima> materiaPrimas = new ArrayList<>();
        materiaPrimaRepository.findAll().forEach(materiaPrimas::add);

        return materiaPrimas;
    }
}

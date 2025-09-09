package infnet.ds.tp3.sistemainterno.repositories;

import infnet.ds.tp3.sistemainterno.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}

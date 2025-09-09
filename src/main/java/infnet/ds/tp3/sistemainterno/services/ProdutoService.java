package infnet.ds.tp3.sistemainterno.services;

import infnet.ds.tp3.sistemainterno.models.Produto;
import infnet.ds.tp3.sistemainterno.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto createProduto(Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    public Optional<Produto> findProduto(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto updateProduto(Long id, Produto produtoAtualizado) {
        Produto produto = produtoRepository.findById(id).get();

        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setMateriaPrima(produtoAtualizado.getMateriaPrima());

        produtoRepository.save(produto);
        return produto;
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public ArrayList<Produto> findAllProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        produtoRepository.findAll().forEach(produtos::add);

        return produtos;
    }
}

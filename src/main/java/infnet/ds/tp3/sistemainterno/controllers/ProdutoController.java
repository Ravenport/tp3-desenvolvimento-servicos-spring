package infnet.ds.tp3.sistemainterno.controllers;

import infnet.ds.tp3.sistemainterno.models.Produto;
import infnet.ds.tp3.sistemainterno.models.Produto;
import infnet.ds.tp3.sistemainterno.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.createProduto(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> readProduto(@PathVariable long id) {
        Optional<Produto> result = produtoService.findProduto(id);
        Produto produto = null;

        if (result.isPresent()) {
            produto = result.get();
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable long id, @RequestBody Produto produtoAtualizado) {
        Produto produto = produtoService.updateProduto(id, produtoAtualizado);

        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable long id) {
        produtoService.deleteProduto(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Produto>> readProdutos() {
        ArrayList<Produto> produtos = produtoService.findAllProdutos();

        return ResponseEntity.status(HttpStatus.FOUND).body(produtos);
    }
}

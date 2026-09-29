package com.cursospring.produtosapi.controller;

import com.cursospring.produtosapi.model.Produto;
import com.cursospring.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private  ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        //System.out.println("Produto salvo: " + produto.getNome());
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produto.setNome(produto.getNome().trim());
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterProdutoById(@PathVariable String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable String id){
        if(produtoRepository.findById(id).isPresent()){
            produtoRepository.deleteById(id);
        }else {
            throw new RuntimeException("Produto não encontrado");
        }
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable String id, @RequestBody Produto produto){
//        produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public List<Produto> obterProdutos(@RequestParam(required = false) String nome){
        if(nome != null){
            return produtoRepository.findByNome(nome);
        }
        return produtoRepository.findAll();
    }

}

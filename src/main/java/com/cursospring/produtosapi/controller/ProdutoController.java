package com.cursospring.produtosapi.controller;

import com.cursospring.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto salvo: " + produto.getNome());
        return produto;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.principal.controller;

import br.com.principal.dto.ProdutoDTO;
import br.com.principal.model.Produto;
import br.com.principal.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bruna
 */

@RestController
@RequestMapping("/venda")
public class VendaController {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @GetMapping("/listarProdutos")
    public List<ProdutoDTO> listarTodosProdutos(){
        return produtoRepository.buscarTodosOsProdutos();
    }
    
}

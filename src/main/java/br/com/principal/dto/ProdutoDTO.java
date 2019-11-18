/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.principal.dto;

import br.com.principal.model.Estoque;
import br.com.principal.model.Produto;

/**
 *
 * @author davidson ferreira
 */
public class ProdutoDTO {

    private Produto produto;
    private Estoque estoqueProduto;

    public ProdutoDTO(Produto produto, Estoque estoque) {
        this.produto = produto;
        this.estoqueProduto = estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Estoque getEstoqueProduto() {
        return estoqueProduto;
    }

    public void setEstoqueProduto(Estoque estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }
}

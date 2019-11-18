/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.principal.repository;

import br.com.principal.dto.ProdutoDTO;
import br.com.principal.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bruna Costa
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    
    @Query("SELECT new br.com.principal.dto.ProdutoDTO(p,e) FROM Produto p "
            + "JOIN Estoque e ON p.codigo = e.codProduto "
            + "WHERE e.estoque > 0 "
            + " ORDER BY p.descricao")
    List<ProdutoDTO> buscarTodosOsProdutos();
}

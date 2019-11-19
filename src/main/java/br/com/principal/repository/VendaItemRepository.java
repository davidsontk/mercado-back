/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.principal.repository;

import br.com.principal.model.VendaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bruna Costa
 */
@Repository
public interface VendaItemRepository extends JpaRepository<VendaItem, Long> {

    @Override
    VendaItem save(VendaItem vendaItem);
}

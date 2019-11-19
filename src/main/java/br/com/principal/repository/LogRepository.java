/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.principal.repository;

import br.com.principal.model.Cliente;
import br.com.principal.model.Log;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author david
 */
public interface LogRepository extends JpaRepository<Log, Long> {

    @Override
    Log save(Log log);

    @Query("SELECT l FROM Log l "
            + "WHERE l.codCliente.codigo = ?1 "
            + "ORDER BY l.dataHora desc ")
    List<Log> buscarLogPorCodigoCliente(Integer codigoCliente);
}

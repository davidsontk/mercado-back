package br.com.principal.repository;

import br.com.principal.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Davidson
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Override
    Cliente save(Cliente c);

    Cliente findByNome(String nome);

    Cliente findByCpf(String cpf);

    Cliente findByCodigo(Integer codigo);
    
    List<Cliente> findAllByOrderByNomeAsc();
}

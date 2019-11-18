package br.com.principal.controller;

import br.com.principal.model.Cliente;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.principal.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Davidson
 */
@RestController
@RequestMapping("/users")
public class ClienteController {

    private Logger log = LogManager.getLogger(ClienteController.class);

    @Autowired
    private ClienteRepository clienteRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ClienteController(ClienteRepository clienteRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.clienteRepository = clienteRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> signUp(@RequestBody Cliente user) {

        Cliente c = clienteRepository.findByCpf(user.getCpf());
        if (c == null) {
            return new ResponseEntity<>("Cliente não encontrado", HttpStatus.BAD_REQUEST);
        }
        if (checkPassword(user.getSenha(), c.getSenha())) {
            return new ResponseEntity<>(c, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public String cadastroUsuario(@RequestBody Cliente usuario) {
        try {
            String hash = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt(10));
            usuario.setSenha(hash);
            clienteRepository.save(usuario);

            return "Usuário cadastro com sucesso " + usuario.getNome();
        } catch (Exception e) {
            log.error("Erro ao salvar usuario ", e);
            return "Erro ao cadastrar usuario" + usuario.getNome();
        }
    }

    @PostMapping("/alterarUsurio")
    public void alterarUsuario(@RequestBody Cliente usuario) {
        Cliente user;
        // user = (Cliente) clienteRepository.findById(usuario.getId().longValue());

    }

    @GetMapping
    public List<Cliente> listarUsuarios() {
        return clienteRepository.findAllByOrderByNomeAsc();
        //return clienteRepository.findAll();
    }

    private boolean checkPassword(String senha, String senhaPersistida) {
        try {
            return BCrypt.checkpw(senha, senhaPersistida);//(senha, senhaPersistida);
        } catch (Exception e) {
            log.error("Erro ao comparar senha", e);
            return false;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.principal.controller;

import br.com.principal.dto.ProdutoDTO;
import br.com.principal.dto.VendaDTO;
import br.com.principal.dto.VendaProdutoDTO;
import br.com.principal.model.Cliente;
import br.com.principal.model.Log;
import br.com.principal.model.Produto;
import br.com.principal.model.Venda;
import br.com.principal.model.VendaItem;
import br.com.principal.repository.ClienteRepository;
import br.com.principal.repository.LogRepository;
import br.com.principal.repository.ProdutoRepository;
import br.com.principal.repository.VendaItemRepository;
import br.com.principal.repository.VendaRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendaItemRepository vendaItemRepository;

    @Autowired
    private LogRepository logRepository;

    @GetMapping("/listarProdutos")
    public List<ProdutoDTO> listarTodosProdutos() {
        return produtoRepository.buscarTodosOsProdutos();
    }

    @PostMapping
    public void salvarVenda(@RequestBody VendaDTO venda) {
        VendaDTO vendaDTO = venda;
        Cliente cliente = clienteRepository.findByCodigo(vendaDTO.getCodigoCliente());
        Venda v = new Venda();
        v.setCodCliente(cliente);
        v.setDataNegociacao(new Date());
        v.setPagamento(venda.getFormaPagamento());
        v.setValorTotal(vendaDTO.getValorTotalVenda());

        Venda vendaSalva = vendaRepository.save(v);
        this.salvarLog(vendaSalva);
        this.salvarItensVenda(vendaSalva, venda.getListVendaProduto());
    }

    private void salvarItensVenda(Venda venda, ArrayList<VendaProdutoDTO> listaVendaProduto) {

        for (VendaProdutoDTO vendaProduto : listaVendaProduto) {
            Produto produto = produtoRepository.findByCodigo(vendaProduto.getCodigo());
            VendaItem vendaItem = new VendaItem();
            vendaItem.setCodProduto(produto);
            vendaItem.setCodVenda(venda);
            vendaItem.setQuantidade(vendaProduto.getQuantidade());
            vendaItem.setValorTotal(vendaProduto.getQuantidade() * vendaProduto.getValor());
            vendaItemRepository.save(vendaItem);
        }
    }

    private void salvarLog(Venda v) {
        Log log = new Log();
        log.setDataHora(new Date());
        log.setCodCliente(v.getCodCliente());
        String formaPagamento = v.getPagamento() == 'D' ? "Débito" : "Crédito";
        log.setDescricao("Venda realizada na forma de pagamento " + formaPagamento + " no total de R$" + v.getValorTotal());
        logRepository.save(log);
    }

    @GetMapping("historicoVendas/{idCliente}")
    public List<Log> buscarHistoricoDeVendas(@PathVariable Integer idCliente) {
        Cliente c = clienteRepository.findByCodigo(idCliente);
        return logRepository.buscarLogPorCodigoCliente(c.getCodigo());
    }

}

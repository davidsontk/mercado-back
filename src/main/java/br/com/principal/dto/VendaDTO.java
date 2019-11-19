package br.com.principal.dto;

import java.util.ArrayList;

/**
 *
 * @author davidson
 */
public class VendaDTO {

    private Double valorTotalVenda;
    private Integer codigoCliente;
    private Character formaPagamento;
    private ArrayList<VendaProdutoDTO> listVendaProduto;

    public Double getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(Double valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Character getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Character formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public ArrayList<VendaProdutoDTO> getListVendaProduto() {
        return listVendaProduto;
    }

    public void setListVendaProduto(ArrayList<VendaProdutoDTO> listVendaProduto) {
        this.listVendaProduto = listVendaProduto;
    }

}

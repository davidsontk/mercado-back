package br.com.principal.dto;

/**
 *
 * @author davidson
 */
public class VendaProdutoDTO {

    private Integer codigo;
    private String descricaoProduto;
    private Double valor;
    private Integer quantidade;
    private Integer codigoEstoque;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getCodigoEstoque() {
        return codigoEstoque;
    }

    public void setCodigoEstoque(Integer codigoEstoque) {
        this.codigoEstoque = codigoEstoque;
    }

}

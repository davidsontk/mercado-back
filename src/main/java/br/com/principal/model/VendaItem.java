/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.principal.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Bruna Costa
 */
@Entity
@Table(name = "venda_item")
public class VendaItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;

    @Size(max = 100)
    @Column(name = "quantidade")
    private Integer quantidade;

    @Size(max = 100)
    @JoinColumn(referencedColumnName = "codigo", name = "cod_venda")
    @ManyToOne
    private Venda codVenda;

    @Size(max = 20)
    @Column(name = "valor_total")
    private Double valorTotal;

    @Size(max = 100)
    @JoinColumn(referencedColumnName = "codigo", name = "cod_produto")
    @OneToOne
    private Produto codProduto;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Venda codVenda) {
        this.codVenda = codVenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Produto codProduto) {
        this.codProduto = codProduto;
    }

}
/*
CREATE TABLE PUBLIC.VENDA_ITEM(
	CODIGO SERIAL NOT NULL,
	QUANTIDADE INTEGER DEFAULT(1),
	COD_VENDA INTEGER NOT NULL,
	VALOR_TOTAL NUMERIC(15,3),
	COD_PRODUTO INTEGER NOT NULL,

	CONSTRAINT "VEN_ITEM_PK" PRIMARY KEY (CODIGO),
	CONSTRAINT "VENDA_FK" FOREIGN KEY (COD_VENDA) REFERENCES PUBLIC.VENDA(CODIGO),
	CONSTRAINT "PRODUTO_FK" FOREIGN KEY (COD_PRODUTO) REFERENCES PUBLIC.VENDA(CODIGO)
);*/

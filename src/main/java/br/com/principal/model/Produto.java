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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Bruna Costa
 */

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    
    @Size(max=20)
    @Column(name = "valor_unitario")
    private double valorUnitario;
    
    @Size(max=2)
    @Column(name = "unidade")
    private String unidade;
    
    @Size(max=100)
    @JoinColumn(referencedColumnName = "codigo", name = "cod_marca")
    @OneToOne
    private Marca codMarca;
    
    @Size(max=100)
    @JoinColumn(referencedColumnName = "codigo" , name ="cod_grupo")
    @OneToOne
    private Grupo codGrupo; 

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Marca getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(Marca codMarca) {
        this.codMarca = codMarca;
    }

    public Grupo getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(Grupo codGrupo) {
        this.codGrupo = codGrupo;
    }

    
}


/*
CREATE TABLE PUBLIC.PRODUTO(
	CODIGO SERIAL NOT NULL,
	DESCRICAO VARCHAR(80),
	VALOR_UNITARIO NUMERIC(15,3),
	UNIDADE VARCHAR(2),
	COD_MARCA INTEGER NOT NULL,
	COD_GRUPO INTEGER NOT NULL,

	CONSTRAINT "PRODUTO_PK" PRIMARY KEY (CODIGO),
	CONSTRAINT "MARCA_FK" FOREIGN KEY (COD_MARCA) REFERENCES PUBLIC.MARCA(CODIGO),
	CONSTRAINT "GRUPO_FK" FOREIGN KEY (COD_GRUPO) REFERENCES PUBLIC.GRUPO(CODIGO)
);
*/
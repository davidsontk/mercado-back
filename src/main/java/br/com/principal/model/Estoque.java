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
@Table(name = "estoque")
public class Estoque  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo; 
    
    @Size(max=100)
    @JoinColumn(referencedColumnName = "codigo" , name ="cod_produto")
    @OneToOne
    private Produto codProduto;
    
    @Size(max = 100)
    @Column(name = "estoque")
    private Integer estoque;
}

/*
CREATE TABLE PUBLIC.ESTOQUE(
	CODIGO SERIAL NOT NULL,
	COD_PRODUTO INTEGER NOT NULL,
	ESTOQUE INTEGER NOT NULL,

	CONSTRAINT "ESTOQUE_PK" PRIMARY KEY (CODIGO),
	CONSTRAINT "PRODUTO_FK" FOREIGN KEY (COD_PRODUTO) REFERENCES PUBLIC.PRODUTO(CODIGO)
);*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.principal.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="venda")
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo; 
    
    @Size(max=100)
    @JoinColumn(referencedColumnName = "codigo" , name ="cod_cliente")
    @OneToOne
    private Cliente codCliente;
    
    @Size(max=1)
    @Column(name="pagamento")
    private char pagamento;
    
    @Size(max=100)
    @Column(name="valor_total")
    private Double valorTotal;
    
    @Size(max=10)
    @Column(name="data_negociacao")
    private Date dataNegociacao;
}

/*CREATE TABLE PUBLIC.VENDA(
	CODIGO SERIAL NOT NULL,
	COD_CLIENTE INTEGER NOT NULL,
	PAGAMENTO CHAR(1) NOT NULL,
	VALOR_TOTAL NUMERIC(15,3) NOT NULL,
	DATA_NEGOCIACAO DATE NOT NULL,

	CONSTRAINT "VENDA_PK" PRIMARY KEY (CODIGO),
	CONSTRAINT "CLIENTE_FK" FOREIGN KEY (COD_CLIENTE) REFERENCES PUBLIC.CLIENTE(CODIGO)
);
*/
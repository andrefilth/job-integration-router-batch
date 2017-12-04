package br.com.cea.transporte.batch.sercdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "C_GEN_ALMACENES")
public class Armazem {
	
	@Id
	@GeneratedValue
	@Column(name = "id_almacen", nullable = false)
	private Long id;
	
	@Column(name = "desc_almacen", length = 100)
	private String descricao;
	
	@Column(name = "colonia", length = 50)
	private String colonia;

	@Column(name = "cp", length = 50)
	private String cp;

	@Column(name = "ciudad", length = 50)
	private String cidade;
	
	@Column(name = "estado", length = 50)
	private String estado;
	
	@Column(name = "telefono", length = 50)
	private String telefone;
	
	@Column(name = "fax", length = 50)
	private String fax;


	@Column(name = "id_ciudad")
	private Integer idCidade;

	@Column(name = "id_estado")
	private Integer idEstado;

	@Column(name = "id_ciudad_temp")
	private Integer idCidadeTemp;

	@Column(name = "siglas_ris", length = 3)
	private String siglas;
}

package br.com.cea.transporte.batch.sercdc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "C_REL_RUTA_TIENDA")
public class RotasDestino {

	@Id
	@GeneratedValue
	@Column(name = "id_rel_ru_ti", nullable = false)
	private Long id;

	@JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta")
	@ManyToOne(optional = false)
	private RotasMaster rotas;

	@JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen")
	@ManyToOne(optional = false)
	private Armazem armazem;
	
	@Column(name = "fec_registro", nullable = false)
	private Date registro;
}

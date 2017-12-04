package br.com.cea.transporte.batch.sercdc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "C_GEN_RUTAS_MASTER")
public class RotasMaster {

	@Id
	@GeneratedValue
	@Column(name = "id_ruta", nullable = false)
	private Long id;

	@Column(name = "fech_reg_ruta")
	private Date dataRota;
	
	@Column(name = "desc_ruta", length = 50)
	private String descricao;
	
	
}

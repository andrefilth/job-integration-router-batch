package br.com.cea.transporte.batch.sercdc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cea.transporte.batch.sercdc.model.RotasDestino;
import br.com.cea.transporte.batch.sercdc.repository.RotasDestinoRepository;

@Service
public class RotasDestinoService {

	@Autowired
	private RotasDestinoRepository repository;
	
	public List<RotasDestino> consultar() {
		return this.repository.findByOrderByRotasAsc();
	}
}

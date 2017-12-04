package br.com.cea.transporte.batch.sercdc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cea.transporte.batch.sercdc.model.RotasMaster;
import br.com.cea.transporte.batch.sercdc.repository.RotasRepository;

@Service
public class RotasMasterService {

	@Autowired
	private RotasRepository repository;

	public List<RotasMaster> consultarRotas() {
		return this.repository.findByOrderByIdAsc();
	}
}

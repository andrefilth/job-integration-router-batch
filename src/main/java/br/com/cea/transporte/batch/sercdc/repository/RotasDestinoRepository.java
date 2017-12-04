package br.com.cea.transporte.batch.sercdc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cea.transporte.batch.sercdc.model.RotasDestino;

public interface RotasDestinoRepository extends JpaRepository<RotasDestino, Long> {

	List<RotasDestino> findByOrderByRotasAsc();
}

package br.com.cea.transporte.batch.sercdc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cea.transporte.batch.sercdc.model.RotasMaster;

@Repository
public interface RotasMasterRepository extends JpaRepository<RotasMaster, Long> {

	List<RotasMaster> findByOrderByIdAsc();
}

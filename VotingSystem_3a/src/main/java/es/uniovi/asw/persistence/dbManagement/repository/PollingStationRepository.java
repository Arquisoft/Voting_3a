package es.uniovi.asw.persistence.dbManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.ColegioElectoral;

public interface PollingStationRepository extends CrudRepository<ColegioElectoral, Long> {
	
	@SuppressWarnings("unchecked")
	ColegioElectoral save(ColegioElectoral colegio);
	
	List<ColegioElectoral> findAll();
	
	ColegioElectoral findOne(Long id);

}

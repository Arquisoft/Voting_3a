package es.uniovi.asw.dbManagement;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.ColegioElectoral;

public interface PollingStationRepository extends CrudRepository<ColegioElectoral, Long>{
	
}

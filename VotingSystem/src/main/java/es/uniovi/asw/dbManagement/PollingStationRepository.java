package es.uniovi.asw.dbmanagement;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.ColegioElectoral;

public interface PollingStationRepository extends CrudRepository<ColegioElectoral, Long> {

}

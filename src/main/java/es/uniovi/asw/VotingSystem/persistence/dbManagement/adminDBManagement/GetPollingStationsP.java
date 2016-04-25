package es.uniovi.asw.persistence.dbManagement.adminDBManagement;

import java.util.List;

import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.persistence.dbManagement.repository.CircunscripcionRepository;
import es.uniovi.asw.persistence.dbManagement.repository.PollingStationRepository;

public interface GetPollingStationsP {
	
	List<ColegioElectoral> getPollingSttaion(PollingStationRepository pRep);
	
	List<Circunscripcion> getCircunscripciones(CircunscripcionRepository cRep);
	
	ColegioElectoral getById(PollingStationRepository pRep, Long id);

}

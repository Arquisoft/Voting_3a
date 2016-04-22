package es.uniovi.asw.business.systemConfiguration.votingParamsManagement.pollingStationManagement;

import java.util.List;

import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.persistence.dbManagement.repository.CircunscripcionRepository;
import es.uniovi.asw.persistence.dbManagement.repository.PollingStationRepository;

public interface PollingStationService {
	
	public void saveColegio(PollingStationRepository pRep, ColegioElectoral colegio);
	
	public List<ColegioElectoral> getPollingStatons(PollingStationRepository pRep);
	
	public List<Circunscripcion> getCircunscripciones(CircunscripcionRepository cRep);
	
	public ColegioElectoral getById(PollingStationRepository pRep, Long id);

}

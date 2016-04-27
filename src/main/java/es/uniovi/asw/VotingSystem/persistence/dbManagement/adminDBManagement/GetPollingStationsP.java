package es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement;

import java.util.List;

import es.uniovi.asw.dbManagement.CircumscriptionRepository;
import es.uniovi.asw.dbManagement.PollingStationRepository;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;

public interface GetPollingStationsP {
	
	List<ColegioElectoral> getPollingSttaion(PollingStationRepository pRep);
	
	List<Circunscripcion> getCircunscripciones(CircumscriptionRepository cRep);
	
	ColegioElectoral getById(PollingStationRepository pRep, Long id);

}

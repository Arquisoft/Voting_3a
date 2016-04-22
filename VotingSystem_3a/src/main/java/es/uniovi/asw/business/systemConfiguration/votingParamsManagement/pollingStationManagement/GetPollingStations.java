package es.uniovi.asw.business.systemConfiguration.votingParamsManagement.pollingStationManagement;

import java.util.List;

import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.GetPollingStationsP;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.persistence.dbManagement.repository.CircunscripcionRepository;
import es.uniovi.asw.persistence.dbManagement.repository.PollingStationRepository;

class GetPollingStations {
	
	public List<ColegioElectoral> getPollingStatons(PollingStationRepository pRep){
		GetPollingStationsP gp = PersistenceFactory.getPollingStations();
		return gp.getPollingSttaion(pRep);
	}
	
	public List<Circunscripcion> getCircunscripciones(CircunscripcionRepository cRep){
		GetPollingStationsP gp = PersistenceFactory.getPollingStations();
		return gp.getCircunscripciones(cRep);
	}
	
	public ColegioElectoral getById(PollingStationRepository pRep, Long id){
		GetPollingStationsP gp = PersistenceFactory.getPollingStations();
		return gp.getById(pRep, id);
	}

}

package es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.pollingStationManagement;

import java.util.List;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.GetPollingStationsP;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbManagement.CircumscriptionRepository;
import es.uniovi.asw.dbManagement.PollingStationRepository;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;

class GetPollingStations {

	public List<ColegioElectoral> getPollingStatons(PollingStationRepository pRep) {
		GetPollingStationsP gp = PersistenceFactory.getPollingStations();
		return gp.getPollingSttaion(pRep);
	}

	public List<Circunscripcion> getCircunscripciones(CircumscriptionRepository cRep) {
		GetPollingStationsP gp = PersistenceFactory.getPollingStations();
		return gp.getCircunscripciones(cRep);
	}

	public ColegioElectoral getById(PollingStationRepository pRep, Long id) {
		GetPollingStationsP gp = PersistenceFactory.getPollingStations();
		return gp.getById(pRep, id);
	}

}

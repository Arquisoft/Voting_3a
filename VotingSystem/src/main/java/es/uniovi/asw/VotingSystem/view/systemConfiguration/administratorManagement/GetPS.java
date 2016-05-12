package es.uniovi.asw.votingSystem.view.systemConfiguration.administratorManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.CircumscriptionRepository;
import es.uniovi.asw.dbmanagement.PollingStationRepository;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.SysConfigServiceFactory;
import es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.pollingStationManagement.PollingStationService;

public class GetPS {

	private PollingStationRepository pRep;
	private CircumscriptionRepository cRep;

	public GetPS(PollingStationRepository pRep) {
		this.pRep = pRep;
	}

	public GetPS(CircumscriptionRepository cRep) {
		this.cRep = cRep;
	}

	public List<ColegioElectoral> getPollingStations() {
		PollingStationService gp = SysConfigServiceFactory.getPollingStationService();
		return gp.getPollingStatons(pRep);
	}

	public List<Circunscripcion> getCircunscripciones() {
		PollingStationService gp = SysConfigServiceFactory.getPollingStationService();
		return gp.getCircunscripciones(cRep);
	}

	public ColegioElectoral getPollingStation(Long id) {
		PollingStationService gp = SysConfigServiceFactory.getPollingStationService();
		return gp.getById(pRep, id);
	}

}

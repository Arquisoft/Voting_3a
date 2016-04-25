package es.uniovi.asw.view.systemConfiguration.administratorManagement;

import java.util.List;

import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.SysConfigServiceFactory;
import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.pollingStationManagement.PollingStationService;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.persistence.dbManagement.repository.CircunscripcionRepository;
import es.uniovi.asw.persistence.dbManagement.repository.PollingStationRepository;

public class GetPS {
	
	private PollingStationRepository pRep;
	private CircunscripcionRepository cRep;
	
	public GetPS(PollingStationRepository pRep){
		this.pRep = pRep;
	}
	
	public GetPS(CircunscripcionRepository cRep){
		this.cRep = cRep;
	}
	
	public List<ColegioElectoral> getPollingStations(){
		PollingStationService gp = SysConfigServiceFactory.getPollingStationService();
		return gp.getPollingStatons(pRep);
	}
	
	public List<Circunscripcion> getCircunscripciones(){
		PollingStationService gp = SysConfigServiceFactory.getPollingStationService();
		return gp.getCircunscripciones(cRep);
	}
	
	public ColegioElectoral getPollingStation(Long id){
		PollingStationService gp = SysConfigServiceFactory.getPollingStationService();
		return gp.getById(pRep, id);
	}

}

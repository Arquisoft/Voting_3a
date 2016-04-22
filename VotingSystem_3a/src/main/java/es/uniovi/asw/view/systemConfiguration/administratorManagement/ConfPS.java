package es.uniovi.asw.view.systemConfiguration.administratorManagement;

import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.SysConfigServiceFactory;
import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.pollingStationManagement.PollingStationService;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.persistence.dbManagement.repository.PollingStationRepository;

public class ConfPS {
	
	private PollingStationRepository pRep;
	private ColegioElectoral colegio;
	
	public ConfPS(PollingStationRepository pRep, ColegioElectoral colegio){
		this.pRep = pRep;
		this.colegio = colegio;
	}
	
	public void saveColegio(){
		PollingStationService cp = SysConfigServiceFactory.getPollingStationService();
		cp.saveColegio(pRep, colegio);
	}

}

package es.uniovi.asw.votingSystem.view.systemConfiguration.administratorManagement;

import es.uniovi.asw.dbmanagement.PollingStationRepository;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.SysConfigServiceFactory;
import es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.pollingStationManagement.PollingStationService;

public class ConfPS {

	private PollingStationRepository pRep;
	private ColegioElectoral colegio;

	public ConfPS(PollingStationRepository pRep, ColegioElectoral colegio) {
		this.pRep = pRep;
		this.colegio = colegio;
	}

	public void saveColegio() {
		PollingStationService cp = SysConfigServiceFactory.getPollingStationService();
		cp.saveColegio(pRep, colegio);
	}

}

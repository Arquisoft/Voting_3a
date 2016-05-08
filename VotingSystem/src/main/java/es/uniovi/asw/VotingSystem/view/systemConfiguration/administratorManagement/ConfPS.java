package es.uniovi.asw.VotingSystem.view.systemConfiguration.administratorManagement;

import es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.SysConfigServiceFactory;
import es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.pollingStationManagement.PollingStationService;
import es.uniovi.asw.dbManagement.PollingStationRepository;
import es.uniovi.asw.model.ColegioElectoral;

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

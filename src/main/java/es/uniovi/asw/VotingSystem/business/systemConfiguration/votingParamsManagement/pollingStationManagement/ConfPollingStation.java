package es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.pollingStationManagement;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.AddPollingStation;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbManagement.PollingStationRepository;
import es.uniovi.asw.model.ColegioElectoral;

class ConfPollingStation {
	
	public void saveColegio(PollingStationRepository pRep, ColegioElectoral colegio){
		AddPollingStation ps = PersistenceFactory.addPollingStation();
		ps.savePolling(pRep, colegio);
	}

}

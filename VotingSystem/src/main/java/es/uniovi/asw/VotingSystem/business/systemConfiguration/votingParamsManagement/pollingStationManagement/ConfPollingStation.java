package es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.pollingStationManagement;

import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.AddPollingStation;
import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbmanagement.PollingStationRepository;
import es.uniovi.asw.model.ColegioElectoral;

class ConfPollingStation {

	public void saveColegio(PollingStationRepository pRep, ColegioElectoral colegio) {
		AddPollingStation ps = PersistenceFactory.addPollingStation();
		ps.savePolling(pRep, colegio);
	}

}

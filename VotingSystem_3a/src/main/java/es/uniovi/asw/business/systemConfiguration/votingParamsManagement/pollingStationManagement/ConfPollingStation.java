package es.uniovi.asw.business.systemConfiguration.votingParamsManagement.pollingStationManagement;

import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.AddPollingStation;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.persistence.dbManagement.repository.PollingStationRepository;

class ConfPollingStation {
	
	public void saveColegio(PollingStationRepository pRep, ColegioElectoral colegio){
		AddPollingStation ps = PersistenceFactory.addPollingStation();
		ps.savePolling(pRep, colegio);
	}

}

package es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.impl;

import es.uniovi.asw.dbmanagement.PollingStationRepository;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.AddPollingStation;

class AddPollingStationImpl implements AddPollingStation {

	@Override
	public void savePolling(PollingStationRepository pRep, ColegioElectoral colegio) {
		pRep.save(colegio);
	}

}

package es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.impl;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.AddPollingStation;
import es.uniovi.asw.dbManagement.PollingStationRepository;
import es.uniovi.asw.model.ColegioElectoral;

class AddPollingStationImpl implements AddPollingStation{

	@Override
	public void savePolling(PollingStationRepository pRep, ColegioElectoral colegio) {
		pRep.save(colegio);
	}
	
	

}

package es.uniovi.asw.persistence.dbManagement.adminDBManagement.impl;

import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.AddPollingStation;
import es.uniovi.asw.persistence.dbManagement.repository.PollingStationRepository;

class AddPollingStationImpl implements AddPollingStation{

	@Override
	public void savePolling(PollingStationRepository pRep, ColegioElectoral colegio) {
		pRep.save(colegio);
	}
	
	

}

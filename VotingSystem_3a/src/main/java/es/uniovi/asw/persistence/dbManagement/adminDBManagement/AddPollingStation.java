package es.uniovi.asw.persistence.dbManagement.adminDBManagement;

import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.persistence.dbManagement.repository.PollingStationRepository;

public interface AddPollingStation {
	
	public void savePolling(PollingStationRepository pRep, ColegioElectoral colegio);

}

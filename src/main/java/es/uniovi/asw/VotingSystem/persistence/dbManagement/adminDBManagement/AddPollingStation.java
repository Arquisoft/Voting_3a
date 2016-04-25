package es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement;

import es.uniovi.asw.dbManagement.PollingStationRepository;
import es.uniovi.asw.model.ColegioElectoral;

public interface AddPollingStation {
	
	public void savePolling(PollingStationRepository pRep, ColegioElectoral colegio);

}

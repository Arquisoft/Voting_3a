package es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement;

import es.uniovi.asw.dbmanagement.PollingStationRepository;
import es.uniovi.asw.model.ColegioElectoral;

public interface AddPollingStation {

	public void savePolling(PollingStationRepository pRep, ColegioElectoral colegio);

}

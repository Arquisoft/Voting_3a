package es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.pollingStationManagement;

import java.util.List;

import es.uniovi.asw.dbManagement.CircumscriptionRepository;
import es.uniovi.asw.dbManagement.PollingStationRepository;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;

public interface PollingStationService {

	public void saveColegio(PollingStationRepository pRep, ColegioElectoral colegio);

	public List<ColegioElectoral> getPollingStatons(PollingStationRepository pRep);

	public List<Circunscripcion> getCircunscripciones(CircumscriptionRepository cRep);

	public ColegioElectoral getById(PollingStationRepository pRep, Long id);

}

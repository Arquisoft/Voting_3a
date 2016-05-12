package es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.pollingStationManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.CircumscriptionRepository;
import es.uniovi.asw.dbmanagement.PollingStationRepository;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;

public class PollingStationServiceImpl implements PollingStationService {

	@Override
	public void saveColegio(PollingStationRepository pRep, ColegioElectoral colegio) {
		new ConfPollingStation().saveColegio(pRep, colegio);
	}

	@Override
	public List<ColegioElectoral> getPollingStatons(PollingStationRepository pRep) {
		return new GetPollingStations().getPollingStatons(pRep);
	}

	@Override
	public List<Circunscripcion> getCircunscripciones(CircumscriptionRepository cRep) {
		return new GetPollingStations().getCircunscripciones(cRep);
	}

	@Override
	public ColegioElectoral getById(PollingStationRepository pRep, Long id) {
		return new GetPollingStations().getById(pRep, id);
	}

}

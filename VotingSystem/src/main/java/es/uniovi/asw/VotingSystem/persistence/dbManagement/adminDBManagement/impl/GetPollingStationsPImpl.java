package es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.impl;

import java.util.List;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.GetPollingStationsP;
import es.uniovi.asw.dbManagement.CircumscriptionRepository;
import es.uniovi.asw.dbManagement.PollingStationRepository;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;

class GetPollingStationsPImpl implements GetPollingStationsP{

	@Override
	public List<ColegioElectoral> getPollingSttaion(PollingStationRepository pRep) {
		return (List<ColegioElectoral>) pRep.findAll();
	}
	
	@Override
	public List<Circunscripcion> getCircunscripciones(CircumscriptionRepository cRep) {
		return (List<Circunscripcion>) cRep.findAll();
	}

	
	public ColegioElectoral getById(PollingStationRepository pRep, Long id) {
		return pRep.findOne(id);
	}
	
	

}

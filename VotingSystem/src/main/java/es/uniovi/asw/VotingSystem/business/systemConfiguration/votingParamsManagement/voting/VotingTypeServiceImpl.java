package es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.voting;

import java.util.List;

import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public class VotingTypeServiceImpl implements VotingTypeService{

	@Override
	public void saveEleccion(VotingRepository vr, CandidacyRepository oRep, Eleccion e) {
		new ConfVotingType().saveEleccion(vr, oRep, e);
		
	}

	@Override
	public void updateEleccion(VotingRepository vr, Long id) {
		new ConfVotingType().updateEleccion(vr, id);
		
	}

	@Override
	public List<Eleccion> getActiveVotings(VotingRepository vRep) {
		return new GetVotingTypes().getActiveVotings(vRep);
	}

	@Override
	public Eleccion getEleccionById(VotingRepository vRep, CandidacyRepository cRep, Long id) {
		return new GetVotingTypes().getEleccionById(vRep, cRep, id);
	}

	
	
}

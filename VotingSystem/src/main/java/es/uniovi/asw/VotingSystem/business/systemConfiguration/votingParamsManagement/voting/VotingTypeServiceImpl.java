package es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.voting;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public class VotingTypeServiceImpl implements VotingTypeService {

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

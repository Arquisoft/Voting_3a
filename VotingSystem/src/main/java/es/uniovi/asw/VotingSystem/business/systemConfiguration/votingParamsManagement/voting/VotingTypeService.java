package es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.voting;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public interface VotingTypeService {

	public void saveEleccion(VotingRepository vr, CandidacyRepository oRep, Eleccion e);

	public void updateEleccion(VotingRepository vr, Long id);

	public List<Eleccion> getActiveVotings(VotingRepository vRep);

	public Eleccion getEleccionById(VotingRepository vRep, CandidacyRepository cRep, Long id);

}

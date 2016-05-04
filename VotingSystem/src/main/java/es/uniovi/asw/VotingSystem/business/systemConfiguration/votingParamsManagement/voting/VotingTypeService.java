package es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.voting;

import java.util.List;

import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public interface VotingTypeService {

	public void saveEleccion(VotingRepository vr, CandidacyRepository oRep, Eleccion e);

	public void updateEleccion(VotingRepository vr, Long id);

	public List<Eleccion> getActiveVotings(VotingRepository vRep);

	public Eleccion getEleccionById(VotingRepository vRep, CandidacyRepository cRep, Long id);

}

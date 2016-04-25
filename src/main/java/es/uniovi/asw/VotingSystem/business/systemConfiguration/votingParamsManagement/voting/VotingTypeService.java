package es.uniovi.asw.business.systemConfiguration.votingParamsManagement.voting;

import java.util.List;

import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

public interface VotingTypeService {
	
	public void saveEleccion(VotingRepository vr, CandidacyRepository oRep, Eleccion e);
	
	public void updateEleccion(VotingRepository vr, Long id);
	
	public List<Eleccion> getActiveVotings(VotingRepository vRep);
	
	public Eleccion getEleccionById(VotingRepository vRep, CandidacyRepository cRep, Long id);

}

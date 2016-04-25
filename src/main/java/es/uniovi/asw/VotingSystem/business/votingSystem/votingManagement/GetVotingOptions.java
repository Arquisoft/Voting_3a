package es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement;

import java.util.List;

import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.model.Candidatura;

public interface GetVotingOptions {

	
	public List<Candidatura> getVotingOptions(Long idEleccion, CandidacyRepository cRep);
	
	
}

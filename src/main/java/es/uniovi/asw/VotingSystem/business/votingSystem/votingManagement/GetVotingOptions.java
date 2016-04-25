package es.uniovi.asw.business.votingSystem.votingManagement;

import java.util.List;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;

public interface GetVotingOptions {

	
	public List<Candidatura> getVotingOptions(Long idEleccion, CandidacyRepository cRep);
	
	
}

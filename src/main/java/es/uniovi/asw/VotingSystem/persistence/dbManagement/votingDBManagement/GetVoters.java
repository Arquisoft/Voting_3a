package es.uniovi.asw.persistence.dbManagement.votingDBManagement;

import java.util.List;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.persistence.dbManagement.repository.VoterRepository;

public interface GetVoters {
	
	public Voter findByEmail(String email, VoterRepository vtRep);
	
	public List<Voter> findAll(VoterRepository vtRep);

}

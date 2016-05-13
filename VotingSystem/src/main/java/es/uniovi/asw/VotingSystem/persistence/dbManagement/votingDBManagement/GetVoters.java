package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement;

import java.util.List;

import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.model.Voter;

public interface GetVoters {

	public Voter findByEmail(String email, VoterRepository vtRep);

	public List<Voter> findAll(VoterRepository vtRep);

}

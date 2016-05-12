package es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.model.Voter;

public interface GetVoters {

	public Voter findByEmail(String email, VoterRepository vtRep);

	public List<Voter> findAll(VoterRepository vtRep);

}

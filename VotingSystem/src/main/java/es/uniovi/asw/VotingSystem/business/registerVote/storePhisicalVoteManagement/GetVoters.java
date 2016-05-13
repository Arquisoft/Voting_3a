package es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement;

import java.util.List;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.dbManagement.VoterRepository;

public interface GetVoters {

	List<Voter> getVoters(VoterRepository voterRep);

}

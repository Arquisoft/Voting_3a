package es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.model.Voter;

public interface GetVoters {

	List<Voter> getVoters(VoterRepository voterRep);

}

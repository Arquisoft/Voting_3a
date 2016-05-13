package es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;

public interface AddPhysicalVote {

	boolean add(String dniVoter, long idElection, ConfirmedVoteRepository cvRep, VoterRepository voterRep,
			VotingRepository vRep);

}

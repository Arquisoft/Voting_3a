package es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement;

import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.dbManagement.VotingRepository;

public interface AddPhysicalVote {

	boolean add(String dniVoter, long idElection, ConfirmedVoteRepository cvRep,
			VoterRepository voterRep, VotingRepository vRep);


}

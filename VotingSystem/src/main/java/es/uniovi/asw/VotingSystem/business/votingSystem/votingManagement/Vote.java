package es.uniovi.asw.votingSystem.business.votingSystem.votingManagement;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbmanagement.VoteRepository;
import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Voter;

public interface Vote {

	public void votar(VotingRepository vRep, VoterRepository vtRep, VoteRepository voRep, ConfirmedVoteRepository cvRep,
			Voter votante, Candidatura candidatura);

}

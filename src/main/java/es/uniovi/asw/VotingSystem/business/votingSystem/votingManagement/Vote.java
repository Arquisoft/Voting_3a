package es.uniovi.asw.business.votingSystem.votingManagement;


import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VoteRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VoterRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

public interface Vote {

	public void votar(VotingRepository vRep, VoterRepository vtRep, VoteRepository voRep, ConfirmedVoteRepository cvRep, Voter votante, Candidatura candidatura);
		
}

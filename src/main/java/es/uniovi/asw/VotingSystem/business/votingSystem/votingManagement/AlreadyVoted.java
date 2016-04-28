package es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement;

import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.model.Voter;

public interface AlreadyVoted {

	public boolean haVotado(Long idEleccion, Voter votante, ConfirmedVoteRepository cvRep);
	
}

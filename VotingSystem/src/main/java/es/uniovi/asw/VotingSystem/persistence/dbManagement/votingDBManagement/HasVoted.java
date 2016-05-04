package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement;

import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;

public interface HasVoted {

	public boolean alreadyVoted(ConfirmedVoteRepository cvRep, Long idVotante, Long idEleccion);

}

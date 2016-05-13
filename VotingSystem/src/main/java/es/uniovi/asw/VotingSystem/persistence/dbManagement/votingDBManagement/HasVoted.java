package es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;

public interface HasVoted {

	public boolean alreadyVoted(ConfirmedVoteRepository cvRep, Long idVotante, Long idEleccion);

}

package es.uniovi.asw.persistence.dbManagement.votingDBManagement;

import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;

public interface HasVoted {

	public boolean alreadyVoted(ConfirmedVoteRepository cvRep, Long idVotante, Long idEleccion);
	
}

package es.uniovi.asw.business.votingSystem.votingManagement;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;

public interface AlreadyVoted {

	public boolean haVotado(Long idEleccion, Voter votante, ConfirmedVoteRepository cvRep);
	
}

package es.uniovi.asw.votingSystem.business.votingSystem.votingManagement;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.model.Voter;

public interface AlreadyVoted {

	public boolean haVotado(Long idEleccion, Voter votante, ConfirmedVoteRepository cvRep);

}

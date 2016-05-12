package es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;

public interface CheckVote {

	public boolean alreadyVoted(ConfirmedVoteRepository cvRep, Long idVotante, Long idEleccion);
}

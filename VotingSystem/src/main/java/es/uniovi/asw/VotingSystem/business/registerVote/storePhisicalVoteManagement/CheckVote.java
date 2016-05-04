package es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement;

import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;

public interface CheckVote {

	public boolean alreadyVoted(ConfirmedVoteRepository cvRep, Long idVotante, Long idEleccion);
}

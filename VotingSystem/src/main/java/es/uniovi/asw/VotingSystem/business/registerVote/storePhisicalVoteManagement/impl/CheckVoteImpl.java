package es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.impl;

import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.CheckVote;
import es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;

public class CheckVoteImpl implements CheckVote {

	public boolean alreadyVoted(ConfirmedVoteRepository cvRep, Long idVotante, Long idEleccion) {

		return PersistenceFactory.newHasVoted().alreadyVoted(cvRep, idVotante, idEleccion);

	}

}

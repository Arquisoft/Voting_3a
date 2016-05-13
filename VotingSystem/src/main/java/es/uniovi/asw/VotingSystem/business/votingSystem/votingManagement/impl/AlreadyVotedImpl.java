package es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.impl;

import es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.AlreadyVoted;
import es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.model.Voter;

class AlreadyVotedImpl implements AlreadyVoted {

	public boolean haVotado(Long idEleccion, Voter votante, ConfirmedVoteRepository cvRep) {
		return PersistenceFactory.newHasVoted().alreadyVoted(cvRep, votante.getId(), idEleccion);
	}

}

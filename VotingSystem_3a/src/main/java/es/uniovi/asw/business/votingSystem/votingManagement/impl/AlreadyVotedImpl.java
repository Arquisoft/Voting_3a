package es.uniovi.asw.business.votingSystem.votingManagement.impl;


import es.uniovi.asw.business.votingSystem.votingManagement.AlreadyVoted;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;
import es.uniovi.asw.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;

class AlreadyVotedImpl implements AlreadyVoted{

	public boolean haVotado(Long idEleccion, Voter votante, ConfirmedVoteRepository cvRep) {
		return PersistenceFactory.newHasVoted().alreadyVoted(cvRep, votante.getId(), idEleccion);
	}

}

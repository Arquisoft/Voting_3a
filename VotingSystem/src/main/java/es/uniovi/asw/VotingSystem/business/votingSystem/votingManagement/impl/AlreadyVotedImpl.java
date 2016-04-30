package es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement.impl;


import es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement.AlreadyVoted;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.model.Voter;

class AlreadyVotedImpl implements AlreadyVoted{

	public boolean haVotado(Long idEleccion, Voter votante, ConfirmedVoteRepository cvRep) {
		return PersistenceFactory.newHasVoted().alreadyVoted(cvRep, votante.getId(), idEleccion);
	}

}

package es.uniovi.asw.VotingSystem.view.votingSystem.voterManagement;

import es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement.impl.ServicesFactory;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.model.Voter;

public class AlreadyV {

	ConfirmedVoteRepository cvRep;

	public AlreadyV(ConfirmedVoteRepository cvRep) {
		this.cvRep = cvRep;
	}

	public boolean yaHaVotado(Long id, Voter votante) {
		return ServicesFactory.newAlreadyVoted().haVotado(id, votante, cvRep);
	}

}

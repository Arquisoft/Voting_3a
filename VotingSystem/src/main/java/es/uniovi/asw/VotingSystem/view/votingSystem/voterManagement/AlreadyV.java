package es.uniovi.asw.votingSystem.view.votingSystem.voterManagement;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.impl.ServicesFactory;

public class AlreadyV {

	ConfirmedVoteRepository cvRep;

	public AlreadyV(ConfirmedVoteRepository cvRep) {
		this.cvRep = cvRep;
	}

	public boolean yaHaVotado(Long id, Voter votante) {
		return ServicesFactory.newAlreadyVoted().haVotado(id, votante, cvRep);
	}

}

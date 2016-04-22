package es.uniovi.asw.view.votingSystem.voterManagement;

import es.uniovi.asw.business.votingSystem.votingManagement.impl.ServicesFactory;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;
public class AlreadyV {
	
	ConfirmedVoteRepository cvRep;
	
	
	public AlreadyV(ConfirmedVoteRepository cvRep){
		this.cvRep = cvRep;
	}
	
	public boolean yaHaVotado(Long id, Voter votante){
		return ServicesFactory.newAlreadyVoted().haVotado(id, votante, cvRep);
	}

}

package es.uniovi.asw.VotingSystem.view.registerVote.pollingStationPresidentManagement;

import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.PhysicalVoteService;
import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.impl.PhysicalVoteServiceImpl;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;

public class CheckV {

	private ConfirmedVoteRepository cvRep;

	public CheckV(ConfirmedVoteRepository cvRep) {
		super();
		this.cvRep = cvRep;
	}

	public boolean checkV(long idVotante, long idEleccion) {

		PhysicalVoteService physicalVoteService = PhysicalVoteServiceImpl.getInstance();
		return physicalVoteService.checkVote(idVotante, idEleccion, cvRep);
	}

}

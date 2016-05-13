package es.uniovi.asw.votingSystem.view.registerVote.pollingStationPresidentManagement;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.PhysicalVoteService;
import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.impl.PhysicalVoteServiceImpl;

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

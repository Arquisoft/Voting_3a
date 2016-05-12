package es.uniovi.asw.VotingSystem.view.registerVote.pollingStationPresidentManagement;

import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.PhysicalVoteService;
import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.impl.PhysicalVoteServiceImpl;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.dbManagement.VotingRepository;

public class AddPV {

	private ConfirmedVoteRepository cvRep;
	private VoterRepository vRep;
	private VotingRepository voRep;

	public AddPV(ConfirmedVoteRepository cvRep, VoterRepository vRep, VotingRepository voRep) {
		super();
		this.cvRep = cvRep;
		this.vRep = vRep;
		this.voRep = voRep;
	}

	public boolean addPV(String dniVoter, long idElection) {

		PhysicalVoteService physicalVoteService = PhysicalVoteServiceImpl.getInstance();
		return physicalVoteService.add(dniVoter, idElection, cvRep, vRep, voRep);
	}

}

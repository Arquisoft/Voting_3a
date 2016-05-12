package es.uniovi.asw.votingSystem.view.registerVote.pollingStationPresidentManagement;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.PhysicalVoteService;
import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.impl.PhysicalVoteServiceImpl;

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

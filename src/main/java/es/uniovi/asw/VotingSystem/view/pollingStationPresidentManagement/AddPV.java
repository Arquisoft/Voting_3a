package es.uniovi.asw.VotingSystem.view.pollingStationPresidentManagement;

import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.AddPhisicalVote;
import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.impl.AddPhisicalVoteImpl;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.dbManagement.VotingRepository;

public class AddPV {
	
	private ConfirmedVoteRepository cvRep;
	private VoterRepository vRep;
	private VotingRepository eRep;

	public AddPV(ConfirmedVoteRepository cvRep, VoterRepository vRep,
			VotingRepository eRep) {
		super();
		this.cvRep = cvRep;
		this.vRep = vRep;
		this.eRep = eRep;
	}

	public boolean addPV(String dniVoter, long idElection) {
		AddPhisicalVote addPhisicalVote = new AddPhisicalVoteImpl();		
		return addPhisicalVote.add(dniVoter, idElection,
				cvRep, vRep, eRep);
	}
	
	
}

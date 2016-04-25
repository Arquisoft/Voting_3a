package es.uniovi.asw.VotingSystem.view.pollingStationPresidentManagement;

import es.uniovi.asw.business.registerVote.storePhisicalVoteManagement.AddPhisicalVote;
import es.uniovi.asw.business.registerVote.storePhisicalVoteManagement.impl.AddPhisicalVoteImpl;
import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;
import es.uniovi.asw.persistence.dbManagement.repository.EleccionRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VoterRepository;

public class AddPV {
	
	private ConfirmedVoteRepository cvRep;
	private VoterRepository vRep;
	private EleccionRepository eRep;

	public AddPV(ConfirmedVoteRepository cvRep, VoterRepository vRep,
			EleccionRepository eRep) {
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

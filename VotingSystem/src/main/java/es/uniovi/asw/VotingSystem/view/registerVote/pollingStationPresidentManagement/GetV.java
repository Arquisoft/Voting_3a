package es.uniovi.asw.votingSystem.view.registerVote.pollingStationPresidentManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.PhysicalVoteService;
import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.impl.PhysicalVoteServiceImpl;

public class GetV {

	private VoterRepository voterRep;

	public GetV(VoterRepository voterRep) {
		super();
		this.voterRep = voterRep;
	}

	public List<Voter> getV(VoterRepository voterRep) {

		PhysicalVoteService physicalVoteService = PhysicalVoteServiceImpl.getInstance();
		return physicalVoteService.getVoters(voterRep);
	}
}

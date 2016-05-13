package es.uniovi.asw.VotingSystem.view.registerVote.pollingStationPresidentManagement;

import java.util.List;

import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.PhysicalVoteService;
import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.impl.PhysicalVoteServiceImpl;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.model.Voter;

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

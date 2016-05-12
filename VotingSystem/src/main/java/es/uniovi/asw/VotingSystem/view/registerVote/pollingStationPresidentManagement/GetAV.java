package es.uniovi.asw.votingSystem.view.registerVote.pollingStationPresidentManagement;

import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.PhysicalVoteService;
import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.impl.PhysicalVoteServiceImpl;

public class GetAV {

	private VotingRepository vRep;

	public GetAV(VotingRepository vRep) {
		super();
		this.vRep = vRep;
	}

	public Iterable<Eleccion> getAV(VotingRepository vRep) {

		PhysicalVoteService physicalVoteService = PhysicalVoteServiceImpl.getInstance();
		return physicalVoteService.getActiveVoter(vRep);
	}
}

package es.uniovi.asw.VotingSystem.view.registerVote.pollingStationPresidentManagement;

import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.PhysicalVoteService;
import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.impl.PhysicalVoteServiceImpl;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

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

package es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.impl;

import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.GetVoters;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.model.Voter;
import java.util.List;

public class GetVotersImpl implements GetVoters {

	@Override
	public List<Voter> getVoters(VoterRepository voterRep) {
		return PersistenceFactory.newGetVoters().findAll(voterRep);
	}

}

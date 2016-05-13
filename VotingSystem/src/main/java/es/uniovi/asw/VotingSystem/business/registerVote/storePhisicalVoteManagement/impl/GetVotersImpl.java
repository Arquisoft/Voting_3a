package es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.impl;

import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.GetVoters;
import es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.model.Voter;
import java.util.List;

public class GetVotersImpl implements GetVoters {

	@Override
	public List<Voter> getVoters(VoterRepository voterRep) {
		return PersistenceFactory.newGetVoters().findAll(voterRep);
	}

}

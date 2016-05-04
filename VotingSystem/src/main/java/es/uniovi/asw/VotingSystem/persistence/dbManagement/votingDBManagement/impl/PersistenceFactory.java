package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.AddVote;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.GetActiveVotings;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.GetVOptions;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.GetVoters;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.HasVoted;

public class PersistenceFactory {

	public static AddVote newAddVote() {
		return new AddVoteImpl();
	}

	public static GetActiveVotings newGetActiveVotings() {
		return new GetActiveVotingsImpl();
	}

	public static GetVOptions newGetVOptions() {
		return new GetVOptionsImpl();
	}

	public static HasVoted newHasVoted() {
		return new HasVotedImpl();
	}

	public static GetVoters newGetVoters() {
		return new GetVotersImpl();
	}
}

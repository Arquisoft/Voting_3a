package es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.impl;

import es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.AlreadyVoted;
import es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.GetActiveVotings;
import es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.GetVotingOptions;
import es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.Vote;

public class ServicesFactory {

	public static GetActiveVotings newGetActiveVotings() {
		return new GetActiveVotingsImpl();
	}

	public static AlreadyVoted newAlreadyVoted() {
		return new AlreadyVotedImpl();
	}

	public static Vote newVote() {
		return new VoteImpl();
	}

	public static GetVotingOptions newGetVotingOptions() {
		return new GetVotingOptionsImpl();
	}
}

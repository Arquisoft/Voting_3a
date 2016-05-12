package es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.impl;

import java.util.List;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.PhysicalVoteService;

public class PhysicalVoteServiceImpl implements PhysicalVoteService {
	private static PhysicalVoteServiceImpl ourInstance = new PhysicalVoteServiceImpl();

	public static PhysicalVoteServiceImpl getInstance() {
		return ourInstance;
	}

	private PhysicalVoteServiceImpl() {
	}

	@Override
	public boolean add(String dniVoter, long idElection, ConfirmedVoteRepository cvRep, VoterRepository voterRep,
			VotingRepository vRep) {
		return new AddPhysicalVoteImpl().add(dniVoter, idElection, cvRep, voterRep, vRep);
	}

	@Override
	public boolean checkVote(long idVotante, long idEleccion, ConfirmedVoteRepository cvRep) {
		return new CheckVoteImpl().alreadyVoted(cvRep, idVotante, idEleccion);
	}

	@Override
	public List<Voter> getVoters(VoterRepository voterRep) {
		return new GetVotersImpl().getVoters(voterRep);
	}

	@Override
	public Iterable<Eleccion> getActiveVoter(VotingRepository vRep) {
		return new GetActiveVotingsImpl().getActiveVoter(vRep);
	}
}

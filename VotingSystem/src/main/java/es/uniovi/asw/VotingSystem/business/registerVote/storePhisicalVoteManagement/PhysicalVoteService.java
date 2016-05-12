package es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;

public interface PhysicalVoteService {

	boolean add(String dniVoter, long idElection, ConfirmedVoteRepository cvRep, VoterRepository voterRep,
			VotingRepository vRep);

	boolean checkVote(long dniVoter, long idElection, ConfirmedVoteRepository cvRep);

	public List<Voter> getVoters(VoterRepository voterRep);

	Iterable<Eleccion> getActiveVoter(VotingRepository vRep);

}

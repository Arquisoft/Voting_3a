package es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement;

import java.util.List;

import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.dbManagement.VotingRepository;

public interface PhysicalVoteService {

	boolean add(String dniVoter, long idElection, ConfirmedVoteRepository cvRep, VoterRepository voterRep,
			VotingRepository vRep);

	boolean checkVote(long dniVoter, long idElection, ConfirmedVoteRepository cvRep);

	public List<Voter> getVoters(VoterRepository voterRep);

	Iterable<Eleccion> getActiveVoter(VotingRepository vRep);

}

package es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement;

import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public interface GetActiveVotings {

	Iterable<Eleccion> getActiveVoter(VotingRepository vRep);

}

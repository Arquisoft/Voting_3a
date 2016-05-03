package es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement;

import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.dbManagement.VotingRepository;

public interface GetActiveVotings {

	Iterable<Eleccion> getActiveVoter(VotingRepository vRep);

}

package es.uniovi.asw.business.registerVote.storePhisicalVoteManagement;

import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;
import es.uniovi.asw.persistence.dbManagement.repository.EleccionRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VoterRepository;

public interface AddPhisicalVote {

	boolean add(String dniVoter, long idElection, ConfirmedVoteRepository cvRep,
			VoterRepository voterRep, EleccionRepository eRep);

}

package es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.impl;

//import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.AddPhysicalVote;
//import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.AddVote;
import es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.model.VotoConfirmado;
import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.AddPhysicalVote;
import es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement.AddVote;

public class AddPhysicalVoteImpl implements AddPhysicalVote {

	@Override
	public boolean add(String dniVoter, long idElection, ConfirmedVoteRepository cvRep, VoterRepository voterRep,
			VotingRepository vRep) {

		AddVote addVote = PersistenceFactory.newAddVote();

		Voter voter = voterRep.findOneByNif(dniVoter);
		Eleccion eleccion = vRep.findOne(idElection);

		if (voter == null || eleccion == null) {
			return false;
		}

		VotoConfirmado voto = new VotoConfirmado(voter, eleccion);
		addVote.añadirVotoConfirmado(cvRep, voto);

		return true;
	}

}

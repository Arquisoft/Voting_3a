package es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.impl;

import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.model.VotoConfirmado;
import es.uniovi.asw.persistence.dbManagement.votingDBManagement.AddVote;

public class AddPhisicalVoteImpl implements AddPhisicalVote {

	@Override
	public boolean add(String dniVoter, long idElection,
			ConfirmedVoteRepository cvRep,
			VoterRepository voterRep,
			EleccionRepository eRep) {
		
		
		
		Voter voter = voterRep.findOneByNif(dniVoter);
		Eleccion eleccion = eRep.findOne(idElection);
		
		if (voter == null || eleccion == null) {
			return false;
		}
		
		VotoConfirmado voto = new VotoConfirmado(voter, eleccion);
		
		AddVote addVote = PersistenceFactory.newAddVote();
		addVote.añadirVotoConfirmado(cvRep, voto);
		
		return true;
	}
}

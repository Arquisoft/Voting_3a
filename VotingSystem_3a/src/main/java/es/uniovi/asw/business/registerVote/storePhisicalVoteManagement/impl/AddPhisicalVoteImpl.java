package es.uniovi.asw.business.registerVote.storePhisicalVoteManagement.impl;

import es.uniovi.asw.business.registerVote.storePhisicalVoteManagement.AddPhisicalVote;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.model.VotoConfirmado;
import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;
import es.uniovi.asw.persistence.dbManagement.repository.EleccionRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VoterRepository;
import es.uniovi.asw.persistence.dbManagement.votingDBManagement.AddVote;
import es.uniovi.asw.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;

public class AddPhisicalVoteImpl implements AddPhisicalVote {

	@Override
	public boolean add(String dniVoter, long idElection,
			ConfirmedVoteRepository cvRep,
			VoterRepository voterRep,
			EleccionRepository eRep) {
		
		AddVote addVote = PersistenceFactory.newAddVote();
		
		Voter voter = voterRep.findOneByNif(dniVoter);
		Eleccion eleccion = eRep.findOne(idElection);
		
		if (voter == null || eleccion == null) {
			return false;
		}
		
		VotoConfirmado voto = new VotoConfirmado(voter, eleccion);
		
		addVote.añadirVotoConfirmado(cvRep, voto);
		
		return true;
	}
}

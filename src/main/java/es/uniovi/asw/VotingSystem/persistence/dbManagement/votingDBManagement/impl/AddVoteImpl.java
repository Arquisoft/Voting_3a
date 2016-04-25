package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl;

import es.uniovi.asw.model.Voto;
import es.uniovi.asw.persistence.dbManagement.repository.VoteRepository;
import es.uniovi.asw.model.VotoConfirmado;
import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;
import es.uniovi.asw.persistence.dbManagement.votingDBManagement.AddVote;

class AddVoteImpl implements AddVote{

	
	public void añadirVoto(VoteRepository voRep, Voto voto) {
		voRep.save(voto);
	}
	
	@Override
	public void añadirVotoConfirmado(ConfirmedVoteRepository cvRep, VotoConfirmado vc) {
		cvRep.save(vc);
		
	}
}

package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.AddVote;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbManagement.VoteRepository;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.model.VotoConfirmado;

class AddVoteImpl implements AddVote {

	public void añadirVoto(VoteRepository voRep, Voto voto) {
		voRep.save(voto);
	}

	@Override
	public void añadirVotoConfirmado(ConfirmedVoteRepository cvRep, VotoConfirmado vc) {
		cvRep.save(vc);

	}
}

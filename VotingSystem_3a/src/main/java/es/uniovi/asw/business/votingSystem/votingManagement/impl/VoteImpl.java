package es.uniovi.asw.business.votingSystem.votingManagement.impl;

import es.uniovi.asw.business.votingSystem.votingManagement.Vote;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.model.VotoConfirmado;
import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VoteRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VoterRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;
import es.uniovi.asw.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;

class VoteImpl implements Vote{
	
	public void votar(VotingRepository vRep, VoterRepository vtRep ,VoteRepository voRep, ConfirmedVoteRepository cvRep, Voter votante, Candidatura candidatura){
		Voto voto = new Voto();
		voto.setColegio(votante.getColegio());
		voto.setOpcion(candidatura);
		PersistenceFactory.newAddVote().añadirVoto(voRep, voto);
		VotoConfirmado vc = new VotoConfirmado();
		Eleccion e = vRep.findOne(candidatura.getEleccion().getId());
		Voter v = vtRep.findOne(votante.getId());
		vc.setEleccion(e);
		vc.setVotante(v);
		vc.setHaVotado(true);
		PersistenceFactory.newAddVote().añadirVotoConfirmado(cvRep, vc);
	}
}

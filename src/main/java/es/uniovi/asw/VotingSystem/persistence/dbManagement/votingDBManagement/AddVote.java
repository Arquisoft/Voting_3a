package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement;


import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbManagement.VoteRepository;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.model.VotoConfirmado;


public interface AddVote {
		
	public void añadirVoto(VoteRepository voRep, Voto voto);
	
	public void añadirVotoConfirmado(ConfirmedVoteRepository cvRep, VotoConfirmado vc);
	
}

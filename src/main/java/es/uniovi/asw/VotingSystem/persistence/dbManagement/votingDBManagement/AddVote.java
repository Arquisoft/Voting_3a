package es.uniovi.asw.persistence.dbManagement.votingDBManagement;


import es.uniovi.asw.model.Voto;
import es.uniovi.asw.persistence.dbManagement.repository.VoteRepository;



import es.uniovi.asw.model.VotoConfirmado;
import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;


public interface AddVote {
		
	public void añadirVoto(VoteRepository voRep, Voto voto);
	
	public void añadirVotoConfirmado(ConfirmedVoteRepository cvRep, VotoConfirmado vc);
	
}

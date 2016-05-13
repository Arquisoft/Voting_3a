package es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbmanagement.VoteRepository;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.model.VotoConfirmado;

public interface AddVote {

	public void añadirVoto(VoteRepository voRep, Voto voto);

	public void añadirVotoConfirmado(ConfirmedVoteRepository cvRep, VotoConfirmado vc);

}

package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement;

import java.util.List;

import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public interface GetActiveVotings {
	
	List<Eleccion> getActiveVotings(VotingRepository vr);

	public List<Eleccion> eleccionesActivas(VotingRepository vRep);
	
	public Eleccion buscarPorId(VotingRepository vRep, Long idEleccion);
	
}

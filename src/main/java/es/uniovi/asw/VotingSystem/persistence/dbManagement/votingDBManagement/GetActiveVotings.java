package es.uniovi.asw.persistence.dbManagement.votingDBManagement;

import java.util.List;

import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

public interface GetActiveVotings {
	
	List<Eleccion> getActiveVotings(VotingRepository vr);

	public List<Eleccion> eleccionesActivas(VotingRepository vRep);
	
	public Eleccion buscarPorId(VotingRepository vRep, Long idEleccion);
	
}

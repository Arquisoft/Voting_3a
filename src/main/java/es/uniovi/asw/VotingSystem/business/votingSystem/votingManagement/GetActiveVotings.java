package es.uniovi.asw.business.votingSystem.votingManagement;

import java.util.List;

import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

public interface GetActiveVotings {

	public List<Eleccion> eleccionesActivas(VotingRepository vRep);
	
}

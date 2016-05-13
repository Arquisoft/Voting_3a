package es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement;

import java.util.List;

import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public interface GetActiveVotings {

	public List<Eleccion> eleccionesActivas(VotingRepository vRep);

}

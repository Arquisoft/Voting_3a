package es.uniovi.asw.votingSystem.business.votingSystem.votingManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public interface GetActiveVotings {

	public List<Eleccion> eleccionesActivas(VotingRepository vRep);

}

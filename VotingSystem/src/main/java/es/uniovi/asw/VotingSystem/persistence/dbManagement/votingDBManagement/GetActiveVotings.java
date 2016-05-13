package es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public interface GetActiveVotings {

	List<Eleccion> getActiveVotings(VotingRepository vr);

	public List<Eleccion> eleccionesActivas(VotingRepository vRep);

	public Eleccion buscarPorId(VotingRepository vRep, Long idEleccion);

}

package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement;

import java.util.List;

import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;

public interface GetVOptions {

	public List<Candidatura> getOpcionesDeVoto(CandidacyRepository cRep, Eleccion eleccion);
	
	public List<Candidatura> findAll(CandidacyRepository cRep);
}

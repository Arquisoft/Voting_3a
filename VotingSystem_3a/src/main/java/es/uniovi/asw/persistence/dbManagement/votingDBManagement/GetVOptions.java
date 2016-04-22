package es.uniovi.asw.persistence.dbManagement.votingDBManagement;

import java.util.List;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;

public interface GetVOptions {

	public List<Candidatura> getOpcionesDeVoto(CandidacyRepository cRep, Eleccion eleccion);
	
	public List<Candidatura> findAll(CandidacyRepository cRep);
}

package es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;

public interface GetVOptions {

	public List<Candidatura> getOpcionesDeVoto(CandidacyRepository cRep, Eleccion eleccion);

	public List<Candidatura> findAll(CandidacyRepository cRep);
}

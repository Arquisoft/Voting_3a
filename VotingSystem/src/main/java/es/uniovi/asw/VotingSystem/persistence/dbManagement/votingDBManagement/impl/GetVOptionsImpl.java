package es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement.impl;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement.GetVOptions;

class GetVOptionsImpl implements GetVOptions {

	public List<Candidatura> getOpcionesDeVoto(CandidacyRepository cRep, Eleccion eleccion) {
		return cRep.findByEleccion(eleccion);
	}

	public List<Candidatura> findAll(CandidacyRepository cRep) {
		return (List<Candidatura>) cRep.findAll();
	}

}

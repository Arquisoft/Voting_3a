package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl;

import java.util.List;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.GetVOptions;
import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;

class GetVOptionsImpl implements GetVOptions {

	public List<Candidatura> getOpcionesDeVoto(CandidacyRepository cRep, Eleccion eleccion) {
		return cRep.findByEleccion(eleccion);
	}

	public List<Candidatura> findAll(CandidacyRepository cRep) {
		return (List<Candidatura>) cRep.findAll();
	}

}

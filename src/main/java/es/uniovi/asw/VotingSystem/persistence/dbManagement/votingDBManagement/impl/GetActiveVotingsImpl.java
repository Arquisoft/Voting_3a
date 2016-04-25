package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl;
import java.util.List;

import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

import java.util.ArrayList;

import es.uniovi.asw.persistence.dbManagement.votingDBManagement.GetActiveVotings;

class GetActiveVotingsImpl implements GetActiveVotings {

	@Override
	public List<Eleccion> getActiveVotings(VotingRepository vr) {
		List<Eleccion> resultado = new ArrayList<Eleccion>();
		for(Eleccion e : vr.findAll()){
			if(e.isActiva())
				resultado.add(e);
		}
		return resultado;
	}
	
	public List<Eleccion> eleccionesActivas(VotingRepository vRep){
		return vRep.findByActivaTrue();
	}
	
	public Eleccion buscarPorId(VotingRepository vRep, Long idEleccion){
		return vRep.findOne(idEleccion);
	}

}

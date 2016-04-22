package es.uniovi.asw.business.votingSystem.votingManagement.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uniovi.asw.business.votingSystem.votingManagement.GetActiveVotings;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;
import es.uniovi.asw.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;

class GetActiveVotingsImpl implements GetActiveVotings{

	
	public List<Eleccion> eleccionesActivas(VotingRepository vRep){
		List<Eleccion> resultado = new ArrayList<Eleccion>();
		List<Eleccion> activas = PersistenceFactory.newGetActiveVotings().eleccionesActivas(vRep);
		for(Eleccion e : activas){
			if(e.getFechaFin().after(new Date()))
				resultado.add(e);
		}
		return resultado;
	}
	
}

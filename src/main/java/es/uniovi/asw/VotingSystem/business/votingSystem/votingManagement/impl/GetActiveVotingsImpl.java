package es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement.GetActiveVotings;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

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

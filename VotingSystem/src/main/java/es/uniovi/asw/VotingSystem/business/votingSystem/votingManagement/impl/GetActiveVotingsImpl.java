package es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.GetActiveVotings;
import es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

class GetActiveVotingsImpl implements GetActiveVotings {

	public List<Eleccion> eleccionesActivas(VotingRepository vRep) {
		List<Eleccion> resultado = new ArrayList<Eleccion>();
		List<Eleccion> activas = PersistenceFactory.newGetActiveVotings().eleccionesActivas(vRep);
		for (Eleccion e : activas) {
			if (e.getFechaFin().after(new Date()))
				resultado.add(e);
		}
		return resultado;
	}

}

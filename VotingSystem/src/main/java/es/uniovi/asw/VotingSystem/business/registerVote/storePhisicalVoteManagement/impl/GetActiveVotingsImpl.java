package es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.impl;

import java.util.Date;

import java.util.ArrayList;

import java.util.List;

import es.uniovi.asw.votingSystem.business.registerVote.storePhisicalVoteManagement.GetActiveVotings;
import es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public class GetActiveVotingsImpl implements GetActiveVotings {
	@Override
	public List<Eleccion> getActiveVoter(VotingRepository vRep) {
		List<Eleccion> activas = PersistenceFactory.newGetActiveVotings().getActiveVotings(vRep);
		List<Eleccion> resultado = new ArrayList<Eleccion>();
		for (Eleccion e : activas) {
			if (e.getFechaFin().after(new Date()))
				resultado.add(e);
		}
		return resultado; // TODO

	}

}

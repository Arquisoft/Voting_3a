package es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.GetVotings;

class GetVotingsImpl implements GetVotings {

	@Override
	public List<Eleccion> getVotings(VotingRepository vr) {
		List<Eleccion> todas = (List<Eleccion>) vr.findAll();
		List<Eleccion> elecciones = new ArrayList<>();
		if (!todas.isEmpty()) {
			for (Eleccion e : todas) {
				if (e.getFechaFin() != null && e.getFechaFin().after(new Date(System.currentTimeMillis()))) {
					elecciones.add(e);
				}
			}
		}
		return elecciones;
	}

	@Override
	public Eleccion getEleccionById(VotingRepository vr, CandidacyRepository cRep, Long id) {
		List<Eleccion> elecciones = (List<Eleccion>) vr.findAll();
		for (Eleccion e : elecciones) {
			if (e.getId() == id) {
				e.getOpciones().size();
				return e;
			}
		}
		return null;
	}

}

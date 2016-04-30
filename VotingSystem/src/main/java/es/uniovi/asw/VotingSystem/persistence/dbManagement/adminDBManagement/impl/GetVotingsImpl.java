package es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.GetVotings;
import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

class GetVotingsImpl implements GetVotings{

	@Override
	public List<Eleccion> getVotings(VotingRepository vr) {
		List<Eleccion> elecciones = new ArrayList<>();
		for(Eleccion e : vr.findAll()){
			if(e.getFechaFin().after(new Date(System.currentTimeMillis()))){
				elecciones.add(e);
			}
		}
		return elecciones;
	}

	@Override
	public Eleccion getEleccionById(VotingRepository vr, CandidacyRepository cRep, Long id) {
		List<Eleccion> elecciones = (List<Eleccion>) vr.findAll();
		for(Eleccion e : elecciones){
			if(e.getId() == id){
				e.getOpciones().size();
				return e;
			}
		}
		return null;
	}
	
	

}

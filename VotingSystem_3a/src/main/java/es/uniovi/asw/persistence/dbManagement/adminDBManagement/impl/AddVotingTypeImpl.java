package es.uniovi.asw.persistence.dbManagement.adminDBManagement.impl;

import java.util.List;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.AddVotingType;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

class AddVotingTypeImpl implements AddVotingType{

	@Override
	public void addVotingType(VotingRepository vRep, CandidacyRepository oRep, Eleccion e) {
		vRep.save(e);
		List<Candidatura> opciones = e.getOpciones();
		for(Candidatura o: opciones){
			o.setEleccion(e);
			oRep.save(o);
		}
		oRep.save(new Candidatura("Voto en blanco", e));
	}

	@Override
	public void setActivation(VotingRepository vr, Long id) {
		Eleccion e = vr.findOne(id);
		e.setActiva(! e.isActiva());
		vr.save(e);
	}
}

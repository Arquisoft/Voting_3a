package es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.impl;

import java.util.List;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.AddVotingType;
import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;

class AddVotingTypeImpl implements AddVotingType {

	@Override
	public void addVotingType(VotingRepository vRep, CandidacyRepository oRep, Eleccion e) {
		vRep.save(e);
		List<Candidatura> opciones = e.getOpciones();
		for (Candidatura o : opciones) {
			o.setEleccion(e);
			oRep.save(o);
		}
		oRep.save(new Candidatura("Voto en blanco", e));
	}

	@Override
	public void setActivation(VotingRepository vr, Long id) {
		Eleccion e = vr.findOne(id);
		e.setActiva(!e.isActiva());
		vr.save(e);
	}
}

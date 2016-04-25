package es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.impl;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.GetCandidacyS;
import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;

class GetCandidacySImpl implements GetCandidacyS{

	@Override
	public List<Candidatura> getCandidacys(VotingRepository vRep, CandidacyRepository cRep, Long id) {
		List<Candidatura> candidaturas = new ArrayList<Candidatura>();
		for(Candidatura c : cRep.findAll()){
			if(c.getEleccion().getId() == id){
				candidaturas.add(c);
			}
		}
		return candidaturas; 
	}

	

}

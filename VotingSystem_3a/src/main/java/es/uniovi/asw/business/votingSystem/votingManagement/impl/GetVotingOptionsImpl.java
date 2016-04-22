package es.uniovi.asw.business.votingSystem.votingManagement.impl;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.business.votingSystem.votingManagement.GetVotingOptions;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;

class GetVotingOptionsImpl implements GetVotingOptions{

	
	public List<Candidatura> getVotingOptions(Long idEleccion, CandidacyRepository cRep){
		List<Candidatura> resultado = new ArrayList<Candidatura>();
		List<Candidatura> filtrar = PersistenceFactory.newGetVOptions().findAll(cRep);
		for(Candidatura c : filtrar){
			if(c.getEleccion().getId().equals(idEleccion))
				resultado.add(c);
		}
		return resultado;
	}
	
}

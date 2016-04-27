package es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement.impl;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement.GetVotingOptions;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.model.Candidatura;

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

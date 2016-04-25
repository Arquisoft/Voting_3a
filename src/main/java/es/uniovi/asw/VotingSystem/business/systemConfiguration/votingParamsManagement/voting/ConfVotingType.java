package es.uniovi.asw.business.systemConfiguration.votingParamsManagement.voting;

import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.AddVotingType;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

class ConfVotingType {
	
	public void saveEleccion(VotingRepository vr, CandidacyRepository oRep, Eleccion e){
		AddVotingType votingType = PersistenceFactory.addVotingType();
		votingType.addVotingType(vr, oRep, e);
	}
	
	public void updateEleccion(VotingRepository vr, Long id){
		AddVotingType votingType = PersistenceFactory.addVotingType();
		votingType.setActivation(vr,id);
	}

}

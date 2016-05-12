package es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.voting;

import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.AddVotingType;
import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

class ConfVotingType {

	public void saveEleccion(VotingRepository vr, CandidacyRepository oRep, Eleccion e) {
		AddVotingType votingType = PersistenceFactory.addVotingType();
		votingType.addVotingType(vr, oRep, e);
	}

	public void updateEleccion(VotingRepository vr, Long id) {
		AddVotingType votingType = PersistenceFactory.addVotingType();
		votingType.setActivation(vr, id);
	}

}

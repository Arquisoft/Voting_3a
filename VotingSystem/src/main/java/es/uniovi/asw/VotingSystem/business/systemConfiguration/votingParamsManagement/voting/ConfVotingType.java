package es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.voting;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.AddVotingType;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
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

package es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.voting;

import java.util.List;

import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.GetVotings;
import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

class GetVotingTypes {

	public List<Eleccion> getActiveVotings(VotingRepository vRep) {
		GetVotings vi = PersistenceFactory.getVotings();
		return vi.getVotings(vRep);
	}

	public Eleccion getEleccionById(VotingRepository vRep, CandidacyRepository cRep, Long id) {
		GetVotings vi = PersistenceFactory.getVotings();
		return vi.getEleccionById(vRep, cRep, id);
	}

}

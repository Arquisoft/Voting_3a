package es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.candidacyManagement;

import java.util.List;

import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.GetCandidacyS;
import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;

class GetCandidacys {

	public List<Candidatura> getCandidacys(VotingRepository vRep, CandidacyRepository cRep, Long id) {
		GetCandidacyS gc = PersistenceFactory.getCandidacys();
		return gc.getCandidacys(vRep, cRep, id);
	}

}

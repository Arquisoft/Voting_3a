package es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.candidacyManagement;

import java.util.List;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.GetCandidacyS;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;

class GetCandidacys {

	public List<Candidatura> getCandidacys(VotingRepository vRep, CandidacyRepository cRep, Long id) {
		GetCandidacyS gc = PersistenceFactory.getCandidacys();
		return gc.getCandidacys(vRep, cRep, id);
	}

}

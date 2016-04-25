package es.uniovi.asw.business.systemConfiguration.votingParamsManagement.candidacyManagement;

import java.util.List;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.GetCandidacyS;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

class GetCandidacys {
	
	public List<Candidatura> getCandidacys(VotingRepository vRep, CandidacyRepository cRep, Long id) {
		GetCandidacyS gc = PersistenceFactory.getCandidacys();
		return gc.getCandidacys(vRep, cRep, id);
	}

}

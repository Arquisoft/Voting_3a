package es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.candidacyManagement;

import java.util.List;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.AddCandidacyC;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;

class ConfCandidacy {
	
	public void saveCandidacys(VotingRepository vRep,
			CandidacyRepository cRep, List<Candidatura> candidaturas, Long id) {
		AddCandidacyC c = PersistenceFactory.addCandidacys();
		c.saveCandidacys(vRep, cRep, candidaturas, id);
	}

}

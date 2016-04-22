package es.uniovi.asw.business.systemConfiguration.votingParamsManagement.candidacyManagement;

import java.util.List;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.AddCandidacyC;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

class ConfCandidacy {
	
	public void saveCandidacys(VotingRepository vRep,
			CandidacyRepository cRep, List<Candidatura> candidaturas, Long id) {
		AddCandidacyC c = PersistenceFactory.addCandidacys();
		c.saveCandidacys(vRep, cRep, candidaturas, id);
	}

}

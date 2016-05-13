package es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.candidacyManagement;

import java.util.List;

import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.AddCandidacyC;
import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;

class ConfCandidacy {

	public void saveCandidacys(VotingRepository vRep, CandidacyRepository cRep, List<Candidatura> candidaturas,
			Long id) {
		AddCandidacyC c = PersistenceFactory.addCandidacys();
		c.saveCandidacys(vRep, cRep, candidaturas, id);
	}

}

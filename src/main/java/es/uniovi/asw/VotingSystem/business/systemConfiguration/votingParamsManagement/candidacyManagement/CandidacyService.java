package es.uniovi.asw.business.systemConfiguration.votingParamsManagement.candidacyManagement;

import java.util.List;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

public interface CandidacyService {
	
	public void saveCandidacys(VotingRepository vRep,
			CandidacyRepository cRep, List<Candidatura> candidaturas, Long id);
	
	public List<Candidatura> getCandidacys(VotingRepository vRep, CandidacyRepository cRep, Long id);

}

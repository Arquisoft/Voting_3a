package es.uniovi.asw.business.systemConfiguration.votingParamsManagement.candidacyManagement;

import java.util.List;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

public class CandidacyServiceImpl implements CandidacyService{

	@Override
	public void saveCandidacys(VotingRepository vRep, CandidacyRepository cRep, List<Candidatura> candidaturas,
			Long id) {
		new ConfCandidacy().saveCandidacys(vRep, cRep, candidaturas, id);
		
	}

	@Override
	public List<Candidatura> getCandidacys(VotingRepository vRep, CandidacyRepository cRep, Long id) {
		return new GetCandidacys().getCandidacys(vRep, cRep, id);
	}

}

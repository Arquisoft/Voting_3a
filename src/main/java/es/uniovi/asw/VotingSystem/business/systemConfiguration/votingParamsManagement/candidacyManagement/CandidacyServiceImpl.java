package es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.candidacyManagement;

import java.util.List;

import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;

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

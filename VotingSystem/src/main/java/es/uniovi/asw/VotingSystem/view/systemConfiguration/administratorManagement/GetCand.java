package es.uniovi.asw.VotingSystem.view.systemConfiguration.administratorManagement;

import java.util.List;

import es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.SysConfigServiceFactory;
import es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.candidacyManagement.CandidacyService;
import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;

public class GetCand {

	private VotingRepository vRep;
	private CandidacyRepository cRep;
	private Long id;

	public GetCand(VotingRepository vRep, CandidacyRepository cRep, Long id) {
		this.vRep = vRep;
		this.cRep = cRep;
		this.id = id;
	}

	public List<Candidatura> getCandidacys() {
		CandidacyService gc = SysConfigServiceFactory.getCandidacyService();
		return gc.getCandidacys(vRep, cRep, id);
	}

}

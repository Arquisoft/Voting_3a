package es.uniovi.asw.votingSystem.view.systemConfiguration.administratorManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.SysConfigServiceFactory;
import es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.candidacyManagement.CandidacyService;

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

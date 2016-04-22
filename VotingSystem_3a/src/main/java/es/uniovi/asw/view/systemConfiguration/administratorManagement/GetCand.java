package es.uniovi.asw.view.systemConfiguration.administratorManagement;

import java.util.List;

import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.SysConfigServiceFactory;
import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.candidacyManagement.CandidacyService;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

public class GetCand {
	
	private VotingRepository vRep;
	private CandidacyRepository cRep;
	private Long id;
	
	public GetCand(VotingRepository vRep, CandidacyRepository cRep, Long id) {
		this.vRep = vRep;
		this.cRep = cRep;
		this.id = id;
	}
	
	public List<Candidatura> getCandidacys(){
		CandidacyService gc = SysConfigServiceFactory.getCandidacyService();
		return gc.getCandidacys(vRep, cRep, id);
	}

}

package es.uniovi.asw.view.systemConfiguration.administratorManagement;

import java.util.List;

import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.SysConfigServiceFactory;
import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.candidacyManagement.CandidacyService;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

public class ConfCand {
	
	private VotingRepository vRep;
	private CandidacyRepository cRep;
	private List<Candidatura> candidaturas;
	private Long id;
	
	public ConfCand(VotingRepository vRep, CandidacyRepository cRep, List<Candidatura> candidaturas, Long id){
		this.vRep = vRep;
		this.cRep = cRep;
		this.candidaturas = candidaturas;
		this.id = id;
	}
	
	public void saveCandidaturas(){
		CandidacyService cc = SysConfigServiceFactory.getCandidacyService();
		cc.saveCandidacys(vRep, cRep, candidaturas, id);
	}

}

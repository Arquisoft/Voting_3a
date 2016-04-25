package es.uniovi.asw.VotingSystem.view.systemConfiguration.administratorManagement;

import es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.SysConfigServiceFactory;
import es.uniovi.asw.VotingSystem.business.systemConfiguration.votingParamsManagement.voting.VotingTypeService;
import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public class ConfVT {
	
	private VotingRepository vRep;
	private CandidacyRepository oRep;
	private Eleccion eleccion;
	private Long id;
	
	public ConfVT(VotingRepository vRep, CandidacyRepository oRep, Eleccion eleccion){
		this.vRep = vRep;
		this.oRep = oRep;
		this.eleccion = eleccion;
	}
	
	public ConfVT(VotingRepository vRep, Long id){
		this.vRep = vRep;
		this.id = id;
	}
	
	public void saveEleccion(){
		VotingTypeService gvt = SysConfigServiceFactory.getVotingService();
		gvt.saveEleccion(vRep, oRep, eleccion);
	}
	
	public void updateEleccion(){
		VotingTypeService gvt = SysConfigServiceFactory.getVotingService();
		gvt.updateEleccion(vRep, id);
	}

}

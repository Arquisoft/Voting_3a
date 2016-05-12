package es.uniovi.asw.votingSystem.view.systemConfiguration.administratorManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.SysConfigServiceFactory;
import es.uniovi.asw.votingSystem.business.systemConfiguration.votingParamsManagement.voting.VotingTypeService;

public class GetVT {

	private VotingRepository vRep;
	private CandidacyRepository cRep;
	private Long id;

	public GetVT(VotingRepository vRep) {
		this.vRep = vRep;
	}

	public GetVT(VotingRepository vRep, CandidacyRepository cRep, Long id) {
		this.vRep = vRep;
		this.cRep = cRep;
		this.id = id;
	}

	public Eleccion getById() {
		VotingTypeService gvt = SysConfigServiceFactory.getVotingService();
		return gvt.getEleccionById(vRep, cRep, id);
	}

	public List<Eleccion> getActiveVotings() {
		VotingTypeService gvt = SysConfigServiceFactory.getVotingService();
		return gvt.getActiveVotings(vRep);
	}

}

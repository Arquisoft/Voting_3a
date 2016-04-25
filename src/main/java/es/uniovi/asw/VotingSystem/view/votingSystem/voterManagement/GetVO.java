package es.uniovi.asw.VotingSystem.view.votingSystem.voterManagement;

import java.util.List;

import es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement.impl.ServicesFactory;
import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.model.Candidatura;

public class GetVO {
	
	private CandidacyRepository cRep;
	
	public GetVO(CandidacyRepository cRep){
		this.cRep = cRep;
	}
	
	public List<Candidatura> obtenerOpciones(Long idEleccion){
		return ServicesFactory.newGetVotingOptions().getVotingOptions(idEleccion, cRep);
	}

}

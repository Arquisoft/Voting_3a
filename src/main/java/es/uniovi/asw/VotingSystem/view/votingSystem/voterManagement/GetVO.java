package es.uniovi.asw.view.votingSystem.voterManagement;

import java.util.List;

import es.uniovi.asw.business.votingSystem.votingManagement.impl.ServicesFactory;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;

public class GetVO {
	
	private CandidacyRepository cRep;
	
	public GetVO(CandidacyRepository cRep){
		this.cRep = cRep;
	}
	
	public List<Candidatura> obtenerOpciones(Long idEleccion){
		return ServicesFactory.newGetVotingOptions().getVotingOptions(idEleccion, cRep);
	}

}

package es.uniovi.asw.votingSystem.view.votingSystem.voterManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.impl.ServicesFactory;

public class GetVO {

	private CandidacyRepository cRep;

	public GetVO(CandidacyRepository cRep) {
		this.cRep = cRep;
	}

	public List<Candidatura> obtenerOpciones(Long idEleccion) {
		return ServicesFactory.newGetVotingOptions().getVotingOptions(idEleccion, cRep);
	}

}

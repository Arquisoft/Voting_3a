package es.uniovi.asw.votingSystem.business.votingSystem.votingManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.model.Candidatura;

public interface GetVotingOptions {

	public List<Candidatura> getVotingOptions(Long idEleccion, CandidacyRepository cRep);

}

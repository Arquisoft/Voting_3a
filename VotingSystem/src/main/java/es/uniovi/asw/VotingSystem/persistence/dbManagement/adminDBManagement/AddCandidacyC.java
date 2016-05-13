package es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;

public interface AddCandidacyC {

	public void saveCandidacys(VotingRepository vRep, CandidacyRepository cRep, List<Candidatura> candidaturas,
			Long id);

}

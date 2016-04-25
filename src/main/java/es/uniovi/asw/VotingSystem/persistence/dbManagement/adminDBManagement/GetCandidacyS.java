package es.uniovi.asw.persistence.dbManagement.adminDBManagement;

import java.util.List;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

public interface GetCandidacyS {
	
	List<Candidatura> getCandidacys(VotingRepository vRep, CandidacyRepository cRep, Long id);

}

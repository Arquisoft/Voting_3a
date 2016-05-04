package es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement;

import java.util.List;

import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;

public interface GetCandidacyS {

	List<Candidatura> getCandidacys(VotingRepository vRep, CandidacyRepository cRep, Long id);

}

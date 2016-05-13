package es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;

public interface GetCandidacyS {

	List<Candidatura> getCandidacys(VotingRepository vRep, CandidacyRepository cRep, Long id);

}

package es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public interface AddVotingType {

	void addVotingType(VotingRepository vr, CandidacyRepository oRep, Eleccion e);

	void setActivation(VotingRepository vr, Long id);

}

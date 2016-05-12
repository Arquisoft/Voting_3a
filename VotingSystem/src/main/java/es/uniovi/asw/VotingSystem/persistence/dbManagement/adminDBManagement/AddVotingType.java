package es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement;

import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public interface AddVotingType {

	void addVotingType(VotingRepository vr, CandidacyRepository oRep, Eleccion e);

	void setActivation(VotingRepository vr, Long id);

}

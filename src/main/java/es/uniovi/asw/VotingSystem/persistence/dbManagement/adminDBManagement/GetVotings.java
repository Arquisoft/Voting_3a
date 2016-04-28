package es.uniovi.asw.VotingSystem.persistence.dbManagement.adminDBManagement;

import java.util.List;

import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public interface GetVotings {
	
	List<Eleccion> getVotings(VotingRepository vr);
	
	Eleccion getEleccionById(VotingRepository vr, CandidacyRepository cRep, Long id);
}

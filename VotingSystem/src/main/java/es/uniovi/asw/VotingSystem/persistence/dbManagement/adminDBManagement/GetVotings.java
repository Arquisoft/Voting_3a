package es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

public interface GetVotings {

	List<Eleccion> getVotings(VotingRepository vr);

	Eleccion getEleccionById(VotingRepository vr, CandidacyRepository cRep, Long id);
}

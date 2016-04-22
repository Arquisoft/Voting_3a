package es.uniovi.asw.persistence.dbManagement.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Voter;

public interface VoterRepository extends CrudRepository<Voter,Serializable> {
	
	List<Voter> findAll();
	
	Voter findOneByEmail(String email);

	Voter findOneByNif(String dniVoter);
	
	List<Voter> findByEmail(String email);
	
}

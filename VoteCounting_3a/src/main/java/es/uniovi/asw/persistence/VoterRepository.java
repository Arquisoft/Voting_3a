package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Voter;

public interface VoterRepository extends CrudRepository<Voter, Long>{
	Voter findById(Long id);

}

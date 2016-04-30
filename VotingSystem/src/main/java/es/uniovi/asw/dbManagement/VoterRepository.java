package es.uniovi.asw.dbManagement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Voter;

public interface VoterRepository extends CrudRepository<Voter, Long> {

	public Voter findById(Long id);
	
	Voter findOneByEmail(String email);
	
	List<Voter> findByEmail(String email);
	
	Voter findOneByNif(String dniVoter);

	public Voter findByEmailAndPassword(String email, String password);

	// public Voter findOne(Long primaryKey);

	// public Iterable<Voter> findAll();

	// public long count();

	// public void delete(Voter entity);

	// public boolean exists(Long primaryKey);
	
	// http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

}

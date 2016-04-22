package es.uniovi.asw.dbManagement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.model.Voter;

/**
 * Interfaz que soporta las operaciones CRUD para los objetos Voter
 * 
 * @author Dario Rodríguez García (@dariorg)
 * @author David González García (@davidglezz)
 */

@Repository
public interface VoterRepository extends CrudRepository<Voter, Long> {

	public Voter findByEmail(String email);

	public Voter findByEmailAndPassword(String email, String password);

	@SuppressWarnings("unchecked")
	public Voter save(Voter voter);

	// public Voter findOne(Long primaryKey);

	// public Iterable<Voter> findAll();

	// public long count();

	// public void delete(Voter entity);

	// public boolean exists(Long primaryKey);

}

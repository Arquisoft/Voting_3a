package es.uniovi.asw.dBUpdate;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Voter;

/**
 * Interfaz que soporta las operaciones CRUD para los objeto Voter
 * 
 * @author Dario Rodríguez García (@dariorg)
 *
 */
public interface VoterRepository extends CrudRepository<Voter, Long> {
	
	
	@SuppressWarnings("unchecked")
	Voter save(Voter voter);

}

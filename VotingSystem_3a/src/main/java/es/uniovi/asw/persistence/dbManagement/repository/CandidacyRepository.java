package es.uniovi.asw.persistence.dbManagement.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;

public interface CandidacyRepository extends CrudRepository<Candidatura, Long> {
	
	@SuppressWarnings("unchecked")
	Candidatura save(Candidatura opcion);
	
	List<Candidatura> findByEleccion(Eleccion eleccion);
	
	List<Candidatura> findAll();

}

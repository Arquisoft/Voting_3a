package es.uniovi.asw.dbManagement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;

public interface CandidacyRepository extends CrudRepository<Candidatura, Long>{

	List<Candidatura> findByEleccion(Eleccion eleccion);
	
}

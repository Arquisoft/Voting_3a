package es.uniovi.asw.persistence.dbManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Circunscripcion;

public interface CircunscripcionRepository extends CrudRepository<Circunscripcion, Long> {
	
	@SuppressWarnings("unchecked")
	Circunscripcion save(Circunscripcion circ);
	
	List<Circunscripcion> findAll();
	
	Circunscripcion findOne(Long id);

}

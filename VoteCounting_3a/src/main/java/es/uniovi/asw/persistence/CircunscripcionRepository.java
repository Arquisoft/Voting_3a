package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Circunscripcion;

public interface CircunscripcionRepository extends CrudRepository<Circunscripcion, Long>{
	Circunscripcion findById(Long id);

}

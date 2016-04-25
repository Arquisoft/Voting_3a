package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Eleccion;

public interface EleccionRepository extends CrudRepository<Eleccion, Long>{
	Eleccion findById(Long id);

}

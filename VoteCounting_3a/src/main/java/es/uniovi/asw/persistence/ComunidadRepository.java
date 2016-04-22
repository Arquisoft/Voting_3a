package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.ComunidadAutonoma;

public interface ComunidadRepository extends CrudRepository<ComunidadAutonoma, Long>{
	ComunidadAutonoma findById(Long id);
}

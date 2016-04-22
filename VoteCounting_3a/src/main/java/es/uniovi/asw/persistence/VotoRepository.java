package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Voto;

public interface VotoRepository extends CrudRepository<Voto, Long>{
	Voto findById(Long id);

}

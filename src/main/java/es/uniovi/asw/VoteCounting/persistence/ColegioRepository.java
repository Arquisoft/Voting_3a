package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.ColegioElectoral;

public interface ColegioRepository extends CrudRepository<ColegioElectoral, Long>{
	ColegioElectoral findById(Long id);

}

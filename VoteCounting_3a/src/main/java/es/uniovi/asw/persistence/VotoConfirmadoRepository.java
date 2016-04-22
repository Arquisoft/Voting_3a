package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.VotoConfirmado;

public interface VotoConfirmadoRepository extends CrudRepository<VotoConfirmado, Long>{
	VotoConfirmado findById(Long id);

}

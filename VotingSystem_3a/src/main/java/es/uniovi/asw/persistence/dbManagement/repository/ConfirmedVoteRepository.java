package es.uniovi.asw.persistence.dbManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.VotoConfirmado;
import es.uniovi.asw.model.types.VotoConfirmadoKey;

public interface ConfirmedVoteRepository extends CrudRepository<VotoConfirmado, VotoConfirmadoKey>{


	
	List<VotoConfirmado> findByHaVotadoTrue();
	
	@SuppressWarnings("unchecked")
	VotoConfirmado save(VotoConfirmado vc);
	
	
	
}

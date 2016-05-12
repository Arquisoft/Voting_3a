package es.uniovi.asw.dbmanagement;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.VotoConfirmado;
import es.uniovi.asw.model.types.VotoConfirmadoKey;

public interface ConfirmedVoteRepository extends CrudRepository<VotoConfirmado, VotoConfirmadoKey> {

}

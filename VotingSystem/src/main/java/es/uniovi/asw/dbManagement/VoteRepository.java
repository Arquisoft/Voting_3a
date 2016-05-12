package es.uniovi.asw.dbmanagement;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Voto;

public interface VoteRepository extends CrudRepository<Voto, Long> {

}

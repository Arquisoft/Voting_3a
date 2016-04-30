package es.uniovi.asw.dBUpdate;

import java.util.List;

import es.uniovi.asw.model.Voter;

/**
 * Interfaz que recibe los objetos de los votantes para ser
 * almacenados en la base de datos
 * 
 * 
 * @author Darío Rodríguez García (@dariorg)
 *
 */
public interface Insert {
	
	void saveVoters( List<Voter> voters, String...args);

}

package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.model.Voter;

/**
 * Interfaz Parser (Patrón de diseño Adapter)
 * 
 * @author Dario Rodriguez Garcia (@dariorg)
 * @version 2016.02.09
 *
 */
public interface Parser {
	
	List<Voter> loadUsers(String fichero) throws IOException;

}

package es.uniovi.asw.parser;

import java.io.IOException;

/**
 * Interfaz que provee los servicos para la carga del censo desde fichero
 * 
 * @author Darío Rodríguez García (@dariorg)
 *
 */
public interface ReadCensus {
	
	void readCensus(String...args) throws IOException;
	
}

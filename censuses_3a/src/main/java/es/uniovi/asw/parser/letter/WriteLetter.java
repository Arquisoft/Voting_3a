package es.uniovi.asw.parser.letter;

import es.uniovi.asw.model.Voter;

/**
 * Interfaz adaptadora para los distintos formatos de cartas
 * que se pueden emitir
 * 
 * @author Dario Rodríguez García (@dariorg)
 *
 */
public interface WriteLetter {
	
	void writeLetter( Voter voter );

}

package es.uniovi.asw.parser.letter;

import es.uniovi.asw.model.Voter;

/**
 * @author Dario Rodríguez García (@dariorg)
 * @version 2016.02.14
 *
 */
public class GenerarateLetter {
	
	/**
	 * Método que permite generar las cartas con los datos del censo para
	 * los distintos votantes dependiendo del formato
	 * 
	 * @param format, txt o word
	 * @param voters, lista de votantes de un censo
	 */
	public static void generateLetter( String format, Voter voter ){
		WriteLetter formatLetter;
		if(format.equals("txt")){
			formatLetter = new WriteTxtLetter();
		}else{
			formatLetter = new WriteWordLetter();
		}
		formatLetter.writeLetter(voter);
	}

}

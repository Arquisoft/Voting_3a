package es.uniovi.asw.parser.letter;

import org.docx4j.openpackaging.exceptions.Docx4JException;

import es.uniovi.asw.model.Voter;

public class WriteWordLetter implements WriteLetter{
	
	private WordLetter word = new WordLetter();
	
	@Override
	public void writeLetter(Voter voter) {
		try {
			word.generateLetter(voter);
		} catch (Docx4JException e) {
			System.out.println("Se ha producido un error al generar el documento");
		}
	}

}

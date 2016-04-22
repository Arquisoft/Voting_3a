package es.uniovi.asw.parser.letter;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import es.uniovi.asw.model.Voter;

public class WriteTxtLetter implements WriteLetter{
	
	private TxtLetter txt = new TxtLetter();
	
	@Override
	public void writeLetter(Voter voter) {
		try {
			txt.generateLetter(voter);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("Se ha producido un error al generar el documento");
		}
	}
}

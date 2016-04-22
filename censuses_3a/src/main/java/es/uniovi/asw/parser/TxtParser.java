package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.model.Voter;

/**
 * Clase adaptador para el "parseo" de ficheros TXT
 * 
 * @author Dario Rodriguez Garcia (@dariorg)
 * @version 2016.02.09
 *
 */
public class TxtParser implements Parser{
	
	private LoadFromTxt txt = new LoadFromTxt();
	
	@Override
	public List<Voter> loadUsers(String fichero) throws IOException {
		
		return txt.loadUsers( fichero );
	
	}
}

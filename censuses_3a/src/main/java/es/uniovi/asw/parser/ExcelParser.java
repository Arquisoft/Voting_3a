package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.model.Voter;

/**
 * Clase adaptador para el "parseo" de ficheros Excel
 * 
 * @author Dario Rodriguez Garcia (@dariorg)
 * @version 2016.02.09
 *
 */
public class ExcelParser implements Parser{
	
	private LoadFromExcel excel = new LoadFromExcel();

	@Override
	public List<Voter> loadUsers(String fichero) throws IOException {
		
		return excel.loadUsers(fichero);
	
	}

}

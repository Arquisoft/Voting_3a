package es.uniovi.asw.parser;

import java.io.IOException;

import org.apache.commons.cli.ParseException;

import es.uniovi.asw.parser.input.Input;

/**
 * Clase que crea los parsers para el procesamiento del fichero
 * de entrada
 * 
 * @author Darío Rodríguez García (@dariorg)
 *
 */
public class RCensus implements ReadCensus{
	
	@Override
	public void readCensus(String...args) throws IOException{
		try {
			new Input().getDataInput( args );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Parser parser = createParser(args);
		InsertR insertR = new InsertR();
		insertR.insertVoters(parser, args);
	}

	private Parser createParser(String... args) {
		Parser parser;
		if( args[1].equals("x") ){ 
			parser = new ExcelParser();
		} else { 
			parser = new TxtParser(); 
		}
		return parser;
	}

}

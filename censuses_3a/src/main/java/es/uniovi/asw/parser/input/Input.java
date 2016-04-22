package es.uniovi.asw.parser.input;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;

/**
 * @author Darío Rodríguez García (@dariorg)
 *
 */
public class Input {
	
	/**
	 * Método para pedir los parámetros que permiten seleccionar la extensión del
	 * fichero a cargar
	 * 
	 * @param args
	 * @throws ParseException 
	 */
	public void getDataInput(String...args) throws ParseException{
		Options options = fileOptions();
		CommandLineParser p = new DefaultParser();
		try {
			CommandLine cmd = p.parse( options, args );
			if(cmd.hasOption("x")){
				args[0] = cmd.getOptionValue("x"); args[1] = "x";
			}if(cmd.hasOption("t")){
				args[0] = cmd.getOptionValue("t"); args[1] = "t";
			}
		}catch(UnrecognizedOptionException uoe){
			throw new IllegalArgumentException("Error: parámetros de entrada incorrectos");
		}
		getOutputFormat( args );

	}
	
	public void getOutputFormat(String...args){
		if(! args[2].equals("txt") && ! args[2].equals("word")){
			throw new IllegalArgumentException("Formato de salida de cartas incorrecto");
		}
	}
	
	private Options fileOptions() {
		Options options = new Options();
		options.addOption("x", true, "Cargar datos a partir de un fichero Excel (xlsx)");
		options.addOption("t", true, "Cargar datos a partir de un fichero de texto (txt)");
		return options;
	}

}

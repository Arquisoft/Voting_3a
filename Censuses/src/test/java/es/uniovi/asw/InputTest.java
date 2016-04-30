package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.Test;

import es.uniovi.asw.parser.input.Input;

public class InputTest {


	/**
	 * Método para comprobar la corrección de los parámetros de entrada
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testInput() throws ParseException {
		String [] args = new String[]{"-x", "src/test/resources/test.txt", "txt"} ;
		Options options = new Options();
		options.addOption("x", true, "Cargar datos a partir de un fichero Excel (xlsx)");
		options.addOption("t", true, "Cargar datos a partir de un fichero de texto (txt)");
		CommandLineParser p = new DefaultParser();
		CommandLine cmd = p.parse( options, args );
		if(cmd.hasOption("x")){
			assertEquals("src/test/resources/test.txt",cmd.getOptionValue("x"));
			assertEquals(true, cmd.hasOption("x"));
		}if(cmd.hasOption("t")){
			assertEquals("src/test/resources/test.txt",cmd.getOptionValue("t"));
			assertEquals(true, cmd.hasOption("t"));
		}
	}
	
	/**
	 * Método para comprobar la corrección de los parámetros de formato
	 * de salida de las cartas que se generan durante el proceso
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testLetterFormatPositive() {
		Input input = new Input();
		String [] args = new String[]{"-x", "src/test/resources/test.txt", "txt"} ;
		input.getOutputFormat(args);
		assertEquals("txt", args[2]);
		args[2] = "word";
		input.getOutputFormat(args);
		assertEquals("word", args[2]);
	}
	
	/**
	 * Método para comprobar la corrección de los parámetros de formato
	 * de salida de las cartas que se generan durante el proceso
	 * 
	 * @throws ParseException
	 */
	@Test ( expected = IllegalArgumentException.class )
	public void testLetterFormatNegative() {
		Input input = new Input();
		String [] args = new String[]{"-x", "src/test/resources/test.txt", "xxx"} ;
		input.getOutputFormat(args);
	}

}

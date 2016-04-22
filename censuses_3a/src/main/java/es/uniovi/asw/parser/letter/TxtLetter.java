package es.uniovi.asw.parser.letter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import es.uniovi.asw.model.Voter;

/**
 * @author Dario Rodríguez García (@dariorg)
 *
 */
public class TxtLetter {
	
	
	/**
	 * Método que permite generar las cartas (formato TXT)a ser enviadas a los usuarios
	 * con los datos personales que les permitan emitir su voto electrónico 
	 * 
	 * @param voter, votante para el que generar la carta
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void generateLetter( Voter voter ) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("src/main/resources/letters/" + voter.getNif() + ".txt", "UTF-8");
		writer.println("DATOS DE CENSO ELECTORAL PARA VOTO ELECTRÓNICO");
		writer.println("-----------------------------------------------");
		writer.println("Estimado " 
				+ voter.getNombre() 
				+ " con NIF: "
				+ voter.getNif() 
				+", a continuación se le comunican los datos que le permitirán emitir su voto de manera electrónica:\n");
		writer.println("USUARIO: " + voter.getEmail() + "\n CONTRASEÑA: " + voter.getPassword() + "\n");
		writer.println("DATOS DEL CENSO:\n" + "COLEGIO ELECTORAL: " 
				+ voter.getPollingStationCode());
		writer.println("NOTA: Los datos mostrados arriba son personales."
				+ " Por seguridad no se los comunique a terceras personas");
		writer.println("-----------------------------------------------");
		writer.close();
	}
}

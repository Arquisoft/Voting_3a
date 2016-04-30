package es.uniovi.asw.parser.password;

import org.jasypt.util.password.StrongPasswordEncryptor;

import es.uniovi.asw.model.Voter;

/**
 * Clase que permite llevar a cabo la encritpacion de las contraseñas
 * (lib Jasypt)
 * 
 * @author Dario Rodríguez García (@dariorg)
 *
 */
public class Encryptation {
	
	public static void encryptData(Voter voter) {
		StrongPasswordEncryptor e = new StrongPasswordEncryptor();
		voter.setPassword(e.encryptPassword(voter.getPassword()));
	}
	
}

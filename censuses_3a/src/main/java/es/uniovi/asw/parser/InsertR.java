package es.uniovi.asw.parser;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.dBUpdate.InsertP;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.password.GenerarClave;

/**
 * Clase que crea los objetos para ser enviados a la base de datos
 * 
 * @author Darío Rodríguez García (@dariorg)
 *
 */
public class InsertR{

	public void insertVoters(Parser parser, String... args) throws IOException {
		List<Voter> voters = parser.loadUsers( args[0] );
		for( Voter voter : voters ){
			voter.setPassword(GenerarClave.getPassword(8));
		}
		new InsertP().saveVoters(voters, args);
	}

}

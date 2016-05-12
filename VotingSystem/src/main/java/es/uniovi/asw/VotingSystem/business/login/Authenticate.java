package es.uniovi.asw.votingSystem.business.login;

import es.uniovi.asw.dbmanagement.Persistence;
import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.model.Voter;

public class Authenticate {

	public static Object[] authenticate(String user, String password, VoterRepository vtRep, Voter voter) {
		Voter votante = Persistence.voter.findOneByEmail(user);
		if (votante != null) {
			if (votante.getPassword().equals(password)) {
				voter = votante;
				Object[] objetos = { "voter", voter };
				return objetos;
			}
		} else if (user.equals("admin") && password.equals("admin")) {
			Object[] objetos = { "admin", null };
			return objetos;
		} else if (user.equals("president") && password.equals("president")) {
			Object[] objetos = { "president", null };
			return objetos;
		}
		Object[] objetos = { "incorrecto", null };
		return objetos;
	}

}

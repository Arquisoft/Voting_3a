package es.uniovi.asw.VoteCounting.recuento;

import es.uniovi.asw.dbManagement.Persistence;
import es.uniovi.asw.model.Eleccion;

public class CountSystemFactory {

	public static CountSystem newStdCountSystem(Eleccion voting) {
		return new StdCountSystem(voting);
	}
	
	public static CountSystem newStdCountSystem(long id) {
		Eleccion e = Persistence.voting.findOne(id);
		return e != null ? new StdCountSystem(e) : null;
	}
}

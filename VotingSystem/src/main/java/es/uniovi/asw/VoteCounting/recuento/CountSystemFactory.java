package es.uniovi.asw.VoteCounting.recuento;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.VoteCounting.recuento.impl.StdCountSystem;
import es.uniovi.asw.dbmanagement.Persistence;
import es.uniovi.asw.model.Eleccion;

@Component
@Scope("singleton")
public class CountSystemFactory {

	private Map<Long, CountSystem> systems = new HashMap<Long, CountSystem>();

	public CountSystemFactory() {
		System.out.println("new CountSystemFactory");
	}

	public CountSystem getStdCountSystem(Eleccion voting) {
		Long id = new Long(voting.getId());
		CountSystem cs = systems.get(id);

		if (cs == null) {
			cs = new StdCountSystem(voting);
			systems.put(id, cs);
		}

		return cs;
	}

	public CountSystem getStdCountSystem(long id) {
		Eleccion e = Persistence.voting.findOne(id);
		return e != null ? getStdCountSystem(e) : null;
	}
}

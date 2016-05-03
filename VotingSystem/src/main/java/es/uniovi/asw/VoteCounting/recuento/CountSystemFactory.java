package es.uniovi.asw.VoteCounting.recuento;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.VoteCounting.recuento.impl.StdCountSystem;
import es.uniovi.asw.dbManagement.Persistence;
import es.uniovi.asw.model.Eleccion;

@Component
@Scope("singleton")
public class CountSystemFactory {
	
	private Map<Long, CountSystem> systems = new HashMap<Long, CountSystem>();

	public CountSystem newStdCountSystem(Eleccion voting) {
		Long id = new Long(voting.getId());
		CountSystem cs = systems.get(id);
		
		if (cs == null) {
			cs = new StdCountSystem(voting);
			systems.put(id, cs);
		}
		
		return cs;
	}
	
	public CountSystem newStdCountSystem(long id) {
		Eleccion e = Persistence.voting.findOne(id);
		return e != null ? new StdCountSystem(e) : null;
	}
}

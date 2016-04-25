package es.uniovi.asw.recuento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.ComunidadAutonoma;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.persistence.Repository;

public class StdCountSystem implements CountSystem {

	private long id;

	private Map<String, Long> votos;
	private Map<String, Map<String, Long>> colegios;
	private Map<String, Map<String, Long>> comunidades;

	public StdCountSystem(long id) {
		this.id = id;

		List<ColegioElectoral> coles = (List<ColegioElectoral>) Repository.colegioRep.findAll();

		List<ComunidadAutonoma> comunis = (List<ComunidadAutonoma>) Repository.comunidadRep.findAll();

		votos = new HashMap<String, Long>();

		colegios = new HashMap<String, Map<String, Long>>();

		for (ColegioElectoral co : coles) {
			colegios.put(co.getNombre(), new HashMap<String, Long>());
		}

		for (ComunidadAutonoma co : comunis) {
			comunidades.put(co.getNombre(), new HashMap<String, Long>());
		}

	}

	@Override
	public boolean iniciar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean terminar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashMap<String, Long> getResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> GetOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void calcular() {
		Eleccion e = Repository.eleccionRep.findById(id);

		if (e == null)
		{
			System.out.println("Calculos realizados");
			return;
		}
		
		for (Candidatura cand : e.getOpciones()) {
			votos.put(cand.getNombre(), new Integer(cand.getVotos().size()).longValue());

			for (Voto vot : cand.getVotos()) {
				if (colegios.get(vot.getColegio()).get(cand.getNombre()) == null) {
					colegios.get(vot.getColegio()).put(cand.getNombre(), new Integer(1).longValue());
				} else {
					colegios.get(vot.getColegio()).put(cand.getNombre(),
							colegios.get(vot.getColegio()).get(cand.getNombre()) + 1);
				}

				if (comunidades.get(vot.getColegio().getCircunscripcion().getComunidad())
						.get(cand.getNombre()) == null) {
					comunidades.get(vot.getColegio().getCircunscripcion().getComunidad()).put(cand.getNombre(),
							new Integer(1).longValue());
				} else {
					comunidades.get(vot.getColegio().getCircunscripcion().getComunidad()).put(cand.getNombre(),
							comunidades.get(vot.getColegio().getCircunscripcion().getComunidad()).get(cand.getNombre())
									+ 1);
				}

			}

		}

	}

	@Override
	public Map<String, Long> getVotos() {
		return votos;
	}

	@Override
	public Map<String, Map<String, Long>> getColegios() {
		return colegios;
	}

	@Override
	public Map<String, Map<String, Long>> getComunidades() {
		return comunidades;
	}	

}

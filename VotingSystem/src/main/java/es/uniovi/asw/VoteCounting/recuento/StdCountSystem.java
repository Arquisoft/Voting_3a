package es.uniovi.asw.VoteCounting.recuento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.dbManagement.Persistence;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.ComunidadAutonoma;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voto;

public class StdCountSystem implements CountSystem {

	private Eleccion voting;

	// Opcion, votos
	private Map<String, Long> votos;

	// Colegio, opcion, votos
	private Map<String, Map<String, Long>> colegios;

	// Comunidad, opcion, votos
	private Map<String, Map<String, Long>> comunidades;

	public StdCountSystem(Eleccion voting) {
		this.voting = voting;
		restart();
	}

	private void restart() {
		// Absolutos (Opcion, Votos)
		this.votos = new HashMap<String, Long>();
		List<Candidatura> opciones = (List<Candidatura>) Persistence.candidacy.findByEleccion(voting);
		for (Candidatura candidato : opciones) {
			votos.put(candidato.getNombre(), new Long(0));
		}

		// Por colegios (Colegio, Opcion, Votos)
		this.colegios = new HashMap<String, Map<String, Long>>();
		List<ColegioElectoral> coles = (List<ColegioElectoral>) Persistence.pollingStation.findAll();
		for (ColegioElectoral co : coles) {
			colegios.put(co.getNombre(), new HashMap<String, Long>(votos));
		}

		// Por comunidades (Comunidad, Opcion, Votos)
		this.comunidades = new HashMap<String, Map<String, Long>>();
		List<ComunidadAutonoma> comunis = (List<ComunidadAutonoma>) Persistence.comunidad.findAll();
		for (ComunidadAutonoma co : comunis) {
			comunidades.put(co.getNombre(), new HashMap<String, Long>(votos));
		}
	}

	@Override
	public void iniciar() {
		CountingExecutor.register(this);
	}

	@Override
	public void terminar() {
		CountingExecutor.unregister(this);
	}

	@Override
	public Map<String, Long> getResults() {
		return votos;
	}

	@Override
	public Map<String, Long> getResultsByComunidad() {
		return votos;
	}

	@Override
	public Map<String, Long> getResultsByColegio() {
		return votos;
	}

	@Override
	public String getName() {
		return voting.getNombre();
	}

	@Override
	public List<String> GetOptions() {
		return new ArrayList<String>(votos.keySet());
	}

	@Override
	public void calcular() {

		restart();

		if (voting == null) {
			System.out.println("Calculos no realizados");
			return;
		}

		for (Candidatura cand : voting.getOpciones()) {
			votos.put(cand.getNombre(), new Long(cand.getVotos().size()).longValue());

			for (Voto vot : cand.getVotos()) {

				colegios.get(vot.getColegio()).put(cand.getNombre(),
						colegios.get(vot.getColegio()).get(cand.getNombre()) + 1);

				comunidades.get(vot.getColegio().getCircunscripcion().getComunidad()).put(cand.getNombre(),
						comunidades.get(vot.getColegio().getCircunscripcion().getComunidad()).get(cand.getNombre())
								+ 1);
			}

		}

		System.out.println("Calculos realizados.");
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

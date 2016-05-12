package es.uniovi.asw.VoteCounting.recuento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.VoteCounting.recuento.CountSystem;
import es.uniovi.asw.dbmanagement.Persistence;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.ComunidadAutonoma;
import es.uniovi.asw.model.Eleccion;

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
		System.out.println("StdCountSystem para " + voting.getId() + ": " + voting.getNombre());
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
	public Map<String, Long> getResults() {
		return new HashMap<String, Long>(votos);
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
		
		voting = Persistence.voting.findOne(voting.getId());
		
		System.out.println("Numero de candidatos: " + voting.getOpciones().size());

		for (Candidatura cand : voting.getOpciones()) {
			votos.put(cand.getNombre(), new Long(cand.getVotos().size()));

			System.out.println(cand.getNombre() + " : " + cand.getVotos().size());

			// Implementacion para cuando se permita ver por comunidades y
			// colegios.
			/*
			 * for (Voto vot : cand.getVotos()) {
			 * 
			 * colegios.get(vot.getColegio()).put(cand.getNombre(),
			 * colegios.get(vot.getColegio()).get(cand.getNombre()) + 1);
			 * 
			 * comunidades.get(vot.getColegio().getCircunscripcion().
			 * getComunidad()).put(cand.getNombre(),
			 * comunidades.get(vot.getColegio().getCircunscripcion().
			 * getComunidad()).get(cand.getNombre()) + 1); }
			 */

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((voting == null) ? 0 : voting.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StdCountSystem other = (StdCountSystem) obj;
		if (voting == null) {
			if (other.voting != null)
				return false;
		} else if (!voting.equals(other.voting))
			return false;
		return true;
	}

}

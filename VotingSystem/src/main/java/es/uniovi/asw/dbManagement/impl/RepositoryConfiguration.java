package es.uniovi.asw.dbManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import es.uniovi.asw.dbManagement.CandidacyRepository;
import es.uniovi.asw.dbManagement.CircumscriptionRepository;
import es.uniovi.asw.dbManagement.ComunidadRepository;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbManagement.Persistence;
import es.uniovi.asw.dbManagement.PollingStationRepository;
import es.uniovi.asw.dbManagement.VoteRepository;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.ComunidadAutonoma;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.model.Voto;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = { "es.uniovi.asw.model" })
@EnableJpaRepositories(basePackages = { "es.uniovi.asw.dbManagement" })
@EnableTransactionManagement
public class RepositoryConfiguration {

	@Autowired
	public void inicializar(CandidacyRepository candidacyRepository, CircumscriptionRepository circumscriptionRep,
			PollingStationRepository pollingStationRepository, ComunidadRepository comunidadRep,
			VotingRepository eleccionRep, VoterRepository voterRep, VoteRepository votoRep,
			ConfirmedVoteRepository votoConfirmadoRep) {

		Persistence.candidacy = candidacyRepository;
		Persistence.circumscription = circumscriptionRep;
		Persistence.pollingStation = pollingStationRepository;
		Persistence.comunidad = comunidadRep;
		Persistence.voting = eleccionRep;
		Persistence.voter = voterRep;
		Persistence.vote = votoRep;
		Persistence.confirmedVote = votoConfirmadoRep;

		// insertarDatosEjemplo();
	}

	private void insertarDatosEjemplo() {

		// Elecciones / Votaciones
		Eleccion eleccion1 = Persistence.voting.save(new Eleccion("Elecciones Generales España 2016"));
		Eleccion eleccion2 = Persistence.voting.save(new Eleccion("Elecciones Municipales 2015"));
		Eleccion eleccion3 = Persistence.voting.save(new Eleccion("Elecciones Autonómicas 2014"));

		// Candidaturas / Opciones
		Candidatura candidato1 = Persistence.candidacy.save(new Candidatura("Candidato 1", eleccion1));
		Candidatura candidato2 = Persistence.candidacy.save(new Candidatura("Candidato 2", eleccion1));
		Candidatura candidato3 = Persistence.candidacy.save(new Candidatura("Candidato 3", eleccion1));
		Candidatura candidato4 = Persistence.candidacy.save(new Candidatura("Candidato 4", eleccion1));
		Candidatura candidato5 = Persistence.candidacy.save(new Candidatura("Candidato 5", eleccion1));

		for (Eleccion e : new Eleccion[] { eleccion2, eleccion3 }) {
			for (String c : new String[] { "Candidato 1", "Candidato 2", "Candidato 3", "Candidato 4",
					"Candidato 5" }) {
				Persistence.candidacy.save(new Candidatura(c, e));
			}
		}

		// Comunidades Autonomas
		ComunidadAutonoma asturias = Persistence.comunidad.save(new ComunidadAutonoma("Asturias"));

		for (String c : new String[] { "Galicia", "Castilla y León", "País Vasco", "Cataluña", "Andalucía",
				"Madrid" }) {
			Persistence.comunidad.save(new ComunidadAutonoma(c));
		}

		// Circunscripciones
		Circunscripcion oviedo = Persistence.circumscription.save(new Circunscripcion("Oviedo", asturias));

		for (String c : new String[] { "Gijon", "Aviles", "Mieres" }) {
			Persistence.circumscription.save(new Circunscripcion(c, asturias));
		}

		// Colegios Electorales
		ColegioElectoral naranco = Persistence.pollingStation
				.save(new ColegioElectoral("Ciudad Naranco", "Oviedo", oviedo));
		ColegioElectoral argañosa = Persistence.pollingStation.save(new ColegioElectoral("Argañosa", "Oviedo", oviedo));
		ColegioElectoral vallobin = Persistence.pollingStation.save(new ColegioElectoral("Vallobin", "Oviedo", oviedo));

		// Votantes
		Voter carlos = Persistence.voter.save(new Voter("Carlos", "email1@uniovi.es", "pass1", "7895176D", argañosa));
		Voter raul = Persistence.voter.save(new Voter("Raul", "email2@uniovi.es", "pass2", "98751487D", vallobin));
		Voter amir = Persistence.voter.save(new Voter("Amir", "email3@uniovi.es", "pass3", "1234567B", naranco));
		Voter david = Persistence.voter.save(new Voter("David", "email4@uniovi.es", "pass4", "8747414D", naranco));

		// Votos
		Persistence.vote.save(new Voto(naranco, candidato1));
		Persistence.vote.save(new Voto(naranco, candidato2));
		Persistence.vote.save(new Voto(vallobin, candidato1));
		Persistence.vote.save(new Voto(argañosa, candidato3));

		Persistence.voting.save(eleccion1);

		// Confirmaciones de voto
		/*
		 * Persistence.confirmedVote.save(new VotoConfirmado(david, eleccion1));
		 * Persistence.confirmedVote.save(new VotoConfirmado(raul, eleccion1));
		 * Persistence.confirmedVote.save(new VotoConfirmado(amir, eleccion1));
		 * Persistence.confirmedVote.save(new VotoConfirmado(carlos,
		 * eleccion1));
		 */
	}

}

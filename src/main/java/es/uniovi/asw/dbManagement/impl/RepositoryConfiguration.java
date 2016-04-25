package es.uniovi.asw.dbManagement.impl;

import java.sql.Time;
import java.util.Date;

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
import es.uniovi.asw.model.VotoConfirmado;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = { "es.uniovi.asw.model" })
@EnableJpaRepositories(basePackages = { "es.uniovi.asw.persistence" })
@EnableTransactionManagement
public class RepositoryConfiguration {

	@Autowired
	public void inicializar(CandidacyRepository candidacyRepository, CircumscriptionRepository circumscriptionRep,
			PollingStationRepository pollingStationRepository, ComunidadRepository comunidadRep, VotingRepository eleccionRep,
			VoterRepository voterRep, VoteRepository votoRep, ConfirmedVoteRepository votoConfirmadoRep) {

		Persistence.candidacy = candidacyRepository;
		Persistence.circumscription = circumscriptionRep;
		Persistence.pollingStation = pollingStationRepository;
		Persistence.comunidad = comunidadRep;
		Persistence.voting = eleccionRep;
		Persistence.voter = voterRep;
		Persistence.vote = votoRep;
		Persistence.confirmedVote = votoConfirmadoRep;

		//insertarDatosEjemplo();
	}
	
	

	private void insertarDatosEjemplo() {

		// Eleccion
		Eleccion eleccion1 = new Eleccion("EleccionASW", new Date(), new Date(System.currentTimeMillis() + 86400000),
				new Time(System.currentTimeMillis()), new Time(System.currentTimeMillis() + 100000));

		eleccion1 = Persistence.voting.save(eleccion1);

		// Opciones
		Candidatura can1 = Persistence.candidacy.save(new Candidatura("Coca cola", "Coca cola", "Refresco carbonatado", eleccion1));
		Candidatura can2 = Persistence.candidacy.save(new Candidatura("Fanta", "Fanta", "Refresco carbonatado sabor naranja o limon", eleccion1));
		Candidatura can3 = Persistence.candidacy.save(new Candidatura("Nestea", "Nestea", "Bebida refrescante sin burbujas", eleccion1));

		// Comunidades Autonomas
		ComunidadAutonoma ca = Persistence.comunidad.save(new ComunidadAutonoma("Asturias"));

		// Circunscripciones
		Circunscripcion c1 = Persistence.circumscription.save(new Circunscripcion("Gijon", ca));
		Circunscripcion c2 = Persistence.circumscription.save(new Circunscripcion("Oviedo", ca));
		Circunscripcion c3 = Persistence.circumscription.save(new Circunscripcion("Aviles", ca));
		Circunscripcion c4 = Persistence.circumscription.save(new Circunscripcion("Mieres", ca));

		// Colegios Electorales
		ColegioElectoral colegio1 = Persistence.pollingStation.save(new ColegioElectoral("Colegio de Gijon", "Poblacion gijonesa", c1));
		ColegioElectoral colegio2 = Persistence.pollingStation.save(new ColegioElectoral("Colegio de Oviedo", "Poblacion ovetense", c2));

		// Votantes
		Voter v1 = Persistence.voter.save(new Voter("Carlos", "email1@uniovi.es", "pass1", "7895176D"));
		Voter v2 = Persistence.voter.save(new Voter("Raul", "email2@uniovi.es", "pass2", "98751487D"));
		Voter v3 = Persistence.voter.save(new Voter("Amir", "email3@uniovi.es", "pass3", "1234567B"));
		Voter v4 = Persistence.voter.save(new Voter("David", "email4@uniovi.es", "pass4", "8747414D"));

		// Votos
		Voto voto = Persistence.vote.save(new Voto(colegio1));

		// Confirmaciones de voto
		VotoConfirmado vc = Persistence.confirmedVote.save(new VotoConfirmado(v1, eleccion1));

	}

}

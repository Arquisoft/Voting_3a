package es.uniovi.asw.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = { "es.uniovi.asw.model" })
@EnableJpaRepositories(basePackages = { "es.uniovi.asw.persistence" })
@EnableTransactionManagement
public class RepositoryConfiguration {

	@Autowired
	public void inicializar(CandidaturaRepository candidaturaRep, CircunscripcionRepository circunscripcionRep,
			ColegioRepository colegioRep, ComunidadRepository comunidadRep, EleccionRepository eleccionRep,
			VoterRepository voterRep, VotoRepository votoRep, VotoConfirmadoRepository votoConfirmadoRep) {

		Repository.candidaturaRep = candidaturaRep;
		Repository.circunscripcionRep = circunscripcionRep;
		Repository.colegioRep = colegioRep;
		Repository.comunidadRep = comunidadRep;
		Repository.eleccionRep = eleccionRep;
		Repository.voterRep = voterRep;
		Repository.votoRep = votoRep;
		Repository.votoConfirmadoRep = votoConfirmadoRep;

		//insertarDatosEjemplo();
	}
/*
	private void insertarDatosEjemplo() {

		// Eleccion
		Eleccion eleccion1 = new Eleccion("EleccionASW", new Date(), new Date(System.currentTimeMillis() + 86400000),
				new Time(System.currentTimeMillis()), new Time(System.currentTimeMillis() + 100000));

		eleccion1 = Repository.eleccionRep.save(eleccion1);

		// Opciones
		Candidatura can1 = Repository.candidaturaRep.save(new Candidatura("Coca cola", "Coca cola", "Refresco carbonatado", eleccion1));
		Candidatura can2 = Repository.candidaturaRep.save(new Candidatura("Fanta", "Fanta", "Refresco carbonatado sabor naranja o limon", eleccion1));
		Candidatura can3 = Repository.candidaturaRep.save(new Candidatura("Nestea", "Nestea", "Bebida refrescante sin burbujas", eleccion1));

		// Comunidades Autonomas
		ComunidadAutonoma ca = Repository.comunidadRep.save(new ComunidadAutonoma("Asturias"));

		// Circunscripciones
		Circunscripcion c1 = Repository.circunscripcionRep.save(new Circunscripcion("Gijon", ca));
		Circunscripcion c2 = Repository.circunscripcionRep.save(new Circunscripcion("Oviedo", ca));
		Circunscripcion c3 = Repository.circunscripcionRep.save(new Circunscripcion("Aviles", ca));
		Circunscripcion c4 = Repository.circunscripcionRep.save(new Circunscripcion("Mieres", ca));

		// Colegios Electorales
		ColegioElectoral colegio1 = Repository.colegioRep.save(new ColegioElectoral("Colegio de Gijon", "Poblacion gijonesa", c1));
		ColegioElectoral colegio2 = Repository.colegioRep.save(new ColegioElectoral("Colegio de Oviedo", "Poblacion ovetense", c2));

		// Votantes
		Voter v1 = Repository.voterRep.save(new Voter("Carlos", "email1@uniovi.es", "pass1", "7895176D"));
		Voter v2 = Repository.voterRep.save(new Voter("Raul", "email2@uniovi.es", "pass2", "98751487D"));
		Voter v3 = Repository.voterRep.save(new Voter("Amir", "email3@uniovi.es", "pass3", "1234567B"));
		Voter v4 = Repository.voterRep.save(new Voter("David", "email4@uniovi.es", "pass4", "8747414D"));

		// Votos
		Voto voto = Repository.votoRep.save(new Voto(colegio1));

		// Confirmaciones de voto
		VotoConfirmado vc = Repository.votoConfirmadoRep.save(new VotoConfirmado(v1, eleccion1));

	}
*/
}

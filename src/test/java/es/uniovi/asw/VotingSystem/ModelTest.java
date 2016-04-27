package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.ComunidadAutonoma;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.model.Voto;

public class ModelTest {
	
	private ColegioElectoral colegio;
	private ComunidadAutonoma comunidad;
	private Circunscripcion circun;

	@Test
	public void testCircunscripcionComunidadColegio() {
		comunidad = new ComunidadAutonoma("Comunidad 1");
		assertEquals("Comunidad 1", comunidad.getNombre());
		ComunidadAutonoma comunidad2 = new ComunidadAutonoma("Comunidad 1");
		assertEquals(true, comunidad.equals(comunidad2));
		circun = new Circunscripcion("Circ 1", comunidad);
		Circunscripcion circun2 = new Circunscripcion(comunidad);
		circun2 = new Circunscripcion("Circ 1", comunidad);
		assertEquals(true, circun.equals(circun2));
		circun.setNombre(null);
		assertEquals(false, circun.equals(circun2));
		circun.setNombre("Circ 2");
		assertEquals("Circ 2", circun.getNombre());
		assertEquals(comunidad, circun.getComunidad());
		assertEquals(false, circun.equals(circun2));
		circun2.setComunidad(null);
		circun.toString();
		assertEquals(false, circun.equals(circun2));
		
		//Circunscripciones
		Set<Circunscripcion> circuns = new HashSet<>();
		circuns.add(circun);
		circuns.add(circun2);
		comunidad.setCircunscripciones(circuns);
		comunidad.getCircunscripciones();
		//Colegios electorales
		Set<ColegioElectoral> colegios = new HashSet<ColegioElectoral>();
		colegios.add(new ColegioElectoral("a","b"));
		colegios.add(new ColegioElectoral("a","b"));
		circun.setColegios(colegios);
		circun.getColegios();
		
		colegio = new ColegioElectoral("X", "Grado", circun);
		colegio.setCircunscripcion(circun2);
		assertEquals(circun2, colegio.getCircunscripcion());
		colegio.setPoblacion("Grado");
		assertEquals("Grado", colegio.getPoblacion());
		assertEquals("X", colegio.getNombre());
		colegio.toString();
		ColegioElectoral colegio2 = new ColegioElectoral("X", "Grado", circun2);
		assertEquals(true, colegio.equals(colegio2));
		colegio2.setPoblacion("Y");
		assertEquals(true, colegio.equals(colegio2));
	}
	
	@Test
	public void testColegioVotantesVoto() {
		ColegioElectoral cole = new ColegioElectoral("A", "B");
		Set<Voto> votos = new HashSet<>();
		votos.add(new Voto(cole));
		votos.add(new Voto(cole));
		cole.setVotos(votos);
		
		Set<Voter> votantes = new HashSet<>();
		votantes.add(new Voter(cole));
		votantes.add(new Voter(cole));
		cole.setVotantes(votantes);
	}
	
	@Test
	public void testVotoCandidatura() {
		ColegioElectoral cole = new ColegioElectoral("A", "B");
		Voto voto = new Voto(cole);
		
		Candidatura c = new Candidatura("Candidatura");
		voto = new Voto(c);
		voto.setColegio(cole);
		assertEquals(cole, voto.getColegio());
		assertEquals(c, voto.getOpcion());
	}
	
	@Test
	public void testVoter() {
		Voter voter = new Voter("nombre", "email", "password", "nif");
		voter.setNombre("X");
		assertEquals("X", voter.getNombre());
		voter.setEmail("Y");
		assertEquals("Y", voter.getEmail());
		voter.setPassword("Z");
		assertEquals("Z", voter.getPassword());
		voter.setNif("A");
		assertEquals("A", voter.getNif());
		voter.setColegio(new ColegioElectoral("A", "B"));
		assertEquals("A", voter.getColegio().getNombre());
		voter.setElecciones(null);
		voter.getElecciones();
		voter.toString();
	}
	
	@Test
	public void testVotoConfirmadoEleccionVoto() {
		Eleccion e = new Eleccion("A",new Date(System.currentTimeMillis()),
				new Date(System.currentTimeMillis()),new Time(System.currentTimeMillis()),
				new Time(System.currentTimeMillis()));
		Eleccion e1 = new Eleccion("A",new Date(System.currentTimeMillis()),
				new Date(System.currentTimeMillis()),new Time(System.currentTimeMillis()),
				new Time(System.currentTimeMillis()));
		e.equals(e1);
		e.toString();
		e.setActiva(true);
		assertEquals(true, e.isActiva());
		e.setNombre("A");
		assertEquals("A", e.getNombre());
		e.setFechaInicio(new Date(System.currentTimeMillis() + 100000));
		e.getFechaInicio();
		e.setFechaFin(new Date(System.currentTimeMillis() + 100000));
		e.getFechaFin();
		e.setHoraInicio(new Time(System.currentTimeMillis()));
		e.getHoraInicio();
		e.setHoraFin(new Time(System.currentTimeMillis()));
		e.getHoraFin();
		e.setNumeroOpciones(3);
		assertEquals(3, e.getNumeroOpciones().intValue());
	}

}

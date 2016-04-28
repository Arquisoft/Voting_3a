/**
 * 
 */
package es.uniovi.asw.cobertura.modelo;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.model.VotoConfirmado;

/**
 * @author Amir
 *
 */
public class EleccionTest {

	private Eleccion e; 
	private Date date1= new Date();
	private Time t1 = new Time(0);
	private Time t2 = new Time(154651847);
	private String nombre = "a";

	/**
	 * Test method for {@link es.uniovi.asw.model.Eleccion#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		e = new Eleccion();		
		assertEquals(29791, e.hashCode());
		e= new Eleccion("a" , null, null, new Time(0), new Time(1));
		assertEquals(29888, e.hashCode());
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Eleccion#Eleccion(java.lang.String, java.util.Date, java.util.Date, java.sql.Time, java.sql.Time)}.
	 */
	@Test
	public final void testEleccionStringDateDateTimeTime() {
		Date date2= new Date();
		e= new Eleccion(nombre , date1, date2, t1, t2);
		assertEquals(nombre, e.getNombre());
		assertEquals(date2, e.getFechaFin());
		assertEquals(date1, e.getFechaInicio());
		assertEquals(t2, e.getHoraFin());
		assertEquals(t1, e.getHoraInicio());
		assertNull(e.getNumeroOpciones());
		assertNotNull(e.getOpciones());
		assertEquals(0, e.getOpciones().size());
		assertEquals(0,e.getVotantes().size());
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Eleccion#Eleccion(java.lang.String)}.
	 */
	@Test
	public final void testEleccionString() {	
		e= new Eleccion(nombre);	
		assertEquals(nombre, e.getNombre());
		assertNull(e.getFechaFin());
		assertNull(e.getHoraFin());
		assertNull(e.getNumeroOpciones());
		assertNotNull(e.getOpciones());
		assertEquals(0, e.getOpciones().size());
		assertEquals(0,e.getVotantes().size());


	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Eleccion#Eleccion()}.
	 */
	@Test
	public final void testEleccion() {
		e= new Eleccion();
		assertNull(e.getHoraInicio());
		assertNull(e.getNombre());
		assertNull(e.getHoraInicio());
		assertNull(e.getNumeroOpciones());
		assertNotNull(e.getOpciones());
		assertEquals(0, e.getOpciones().size());
		assertEquals(0,e.getVotantes().size());
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Eleccion#toString()}.
	 */
	@Test
	public final void testToString() {
		e= new Eleccion(nombre , null, null, null, null);		
		String s ="Eleccion [id=null, nombre=a, fechaInicio=null, fechaFin=null, horaInicio=null, horaFin=null, opciones=[]]";
		assertEquals(s, e.toString());
	}

	@Test
	public final void testActiva() {
		e= new Eleccion(nombre , null, null, null, null);	
		e.setActiva(true);
		assertTrue(e.isActiva());
		e.setActiva(false);
		assertFalse(e.isActiva());

	}

	@Test
	public final void testSets() {
		e= new Eleccion(nombre , null, null, null, null);	

		e.setFechaFin(date1);
		assertNotNull(e.getFechaFin());
		e.setFechaInicio(date1);
		assertNotNull(e.getFechaInicio());
		e.setHoraFin(t1);
		e.setHoraInicio(t2);
		assertNotNull(e.getHoraInicio());
		assertNotNull(e.getFechaFin());

		e.setNombre("NuevoNombre");
		assertEquals("NuevoNombre", e.getNombre());

		e.setNumeroOpciones(99);
		assertNotNull(e.getNumeroOpciones());

		List<Candidatura> l = new LinkedList<Candidatura>();
		l.add(new Candidatura());
		l.add(new Candidatura());
		e.setOpciones(l);
		assertEquals(2, e.getOpciones().size());

		Set<VotoConfirmado> v = new HashSet<VotoConfirmado>();
		v.add(new VotoConfirmado(new Voter("a", "b", "c", "d"), new Eleccion("ff")));
		v.add(new VotoConfirmado(new Voter("aa", "ab", "ac", "ad"), new Eleccion("rr")));
		e.setVotantes(v);;
		assertEquals(2, e.getVotantes().size());



		e.setActiva(true);
		assertTrue(e.isActiva());
		e.setActiva(false);
		assertFalse(e.isActiva());
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Eleccion#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		e= new Eleccion();
		Eleccion e1, e2, e3;
		Date date2= new Date();
		e1= new Eleccion(nombre , date1, date2, t1, t2);
		e2= new Eleccion("otroNombre");
		e3= new Eleccion(nombre , date1, date2, t1, t2);

		assertTrue(e.equals(e));
		assertTrue(e1.equals(e3));
		assertTrue(e3.equals(e1));
		
		assertFalse(e.equals(e2));
		assertFalse(e2.equals(e));

		assertFalse(e.equals(new Object()));
		assertFalse(e.equals("otraClase"));

		assertFalse(e.equals(e1));
		assertFalse(e1.equals(e));
		assertFalse(e1.equals(e2));
		assertFalse(e2.equals(e1));
		e3.setNombre(null);
		assertFalse(e1.equals(e3));
		assertFalse(e3.equals(e1));
		
		/* ESTE CASO NUNCA SE PUEDE DAR AUNQUE EL EQUALS LO CONTEMPLA
		e3= new Eleccion(nombre , date1, date2, t1, t2);
		e3.setFechaFin(null);
		assertFalse(e1.equals(e3));
		assertFalse(e3.equals(e1));
	
		e3= new Eleccion(nombre , date1, date2, t1, t2);
		e3.setFechaInicio(null);
		assertFalse(e1.equals(e3));
		assertFalse(e3.equals(e1));
		*/


	}

}

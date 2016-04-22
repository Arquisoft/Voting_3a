/**
 * Un test del models y no trabajo para tripAdvisor ojo... este es otro models. 
 */
package es.uniovi.asw.cobertura.modelo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;

import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.ComunidadAutonoma;


/**
 * @author Amir
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class CircunscripcionTest {
	
	private Circunscripcion c2par = null;
	private Circunscripcion c1par = null;
	private String nombre1 = "n1";
	private String nombre2 = "n2";
	private ComunidadAutonoma comunidad1 = new ComunidadAutonoma("ca1");
	private ComunidadAutonoma comunidad2 = new ComunidadAutonoma("ca2");
	

	@Test
	public void testConstructor2Par() {
		c2par= new Circunscripcion(nombre1, comunidad1);
		assertEquals(nombre1, c2par.getNombre());
		assertEquals(comunidad1, c2par.getComunidad());
		assertEquals(0, c2par.getColegios().size());
		assertNull(c2par.getId());
		assertEquals(0, c2par.getColegios().size());
			
	}
	
	@Test
	public void testConstructor1Par() {
		c2par= new Circunscripcion(comunidad1);
		assertEquals(comunidad1, c2par.getComunidad());
		assertNull(c2par.getNombre());
		assertEquals(0, c2par.getColegios().size());
		assertNull(c2par.getId());
		assertEquals(0, c2par.getColegios().size());
			
	}
	
	@Test
	public void testToString() {
		c2par= new Circunscripcion(nombre1, comunidad1);
		assertEquals("Circunscripcion [id=null, comunidad=ComunidadAutonoma [id=null, nombre=ca1]]",c2par.toString());
	
	}
	
	@Test
	public void testSets() {
		c2par= new Circunscripcion(nombre1, comunidad1);
		assertEquals("Circunscripcion [id=null, comunidad=ComunidadAutonoma [id=null, nombre=ca1]]",c2par.toString());

		//ColegioElectoral cole = new ColegioElectoral("cole", "gio", null);
		Set<ColegioElectoral> coles = new HashSet<ColegioElectoral>();
		c2par.setColegios(coles);
		assertEquals(coles, c2par.getColegios());
		
		c2par.setComunidad(comunidad2);
		assertEquals(comunidad2, c2par.getComunidad());
		
		c2par.setNombre(nombre2);
		assertEquals(nombre2, c2par.getNombre());
	}
	
	@Test
	public void testHash2P() {
		c2par= new Circunscripcion(nombre1, comunidad1);
		assertEquals(3049426, c2par.hashCode());
		
	}
	
	@Test
	public void testHash1P() {
		
		c1par= new Circunscripcion(comunidad1);
		assertEquals(3045967, c1par.hashCode());
		
		c1par= new Circunscripcion(comunidad1);
		c1par.setComunidad(null);
		assertEquals(961, c1par.hashCode());

	}

	@Test
	public void testEquals() {
		c1par= new Circunscripcion(comunidad1);
		c2par= new Circunscripcion(nombre1, comunidad1);
		
		Circunscripcion c2parb = new Circunscripcion(nombre2, comunidad2);
		Circunscripcion c1parb = new Circunscripcion(comunidad2);
		
		assertTrue(c1par.equals(c1par));
		assertTrue(c2par.equals(c2par));
		
		assertFalse(c1par.equals(c2par));
		assertFalse(c2par.equals(c1par));
		
		assertFalse(c2par.equals(c1parb));
		assertFalse(c2parb.equals(c1par));
		
		assertFalse(c1parb.equals(c1par));
		assertFalse(c1par.equals(c1parb));
		
		assertFalse(c1par.equals(null));
		assertFalse(c2par.equals(null));
		
		assertFalse(c2par.equals(comunidad1));

	}

}

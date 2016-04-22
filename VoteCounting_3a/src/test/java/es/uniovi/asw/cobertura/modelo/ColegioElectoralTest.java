/**
 * 
 */
package es.uniovi.asw.cobertura.modelo;

import static org.junit.Assert.*;

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
public class ColegioElectoralTest {

	
	private ColegioElectoral ce ;
	private String nombre1 = "n1";
	private String nombre2 = "n2";
	private String poblacion1 = "p1";
	private String poblacion2 = "p2";
	private Circunscripcion c1 = 
			new Circunscripcion("c1",
					new ComunidadAutonoma("ca1"));
	private Circunscripcion c2 = 
			new Circunscripcion("c2",
					new ComunidadAutonoma("ca2"));	
	
	
	/**
	 * Test method for {@link es.uniovi.asw.model.ColegioElectoral#ColegioElectoral(java.lang.String, java.lang.String, es.uniovi.asw.model.Circunscripcion)}.
	 */
	@Test
	public final void testColegioElectoralStringStringCircunscripcion() {
		ce = new ColegioElectoral(nombre1, poblacion1, c1);
		assertNull(ce.getId());
		assertEquals(c1, ce.getCircunscripcion());
		assertEquals(nombre1, ce.getNombre());
		assertEquals(poblacion1, ce.getPoblacion());
		assertEquals(0, ce.getVotantes().size());
		assertEquals(0, ce.getVotos().size());		
	}
	
	/**
	 * Test method for {@link es.uniovi.asw.model.ColegioElectoral#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		ce = new ColegioElectoral(nombre1, poblacion1, c1);
		assertEquals(31, ce.hashCode());		
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.ColegioElectoral#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		ce = new ColegioElectoral(nombre1, poblacion1, c1);
		
		assertTrue(ce.equals(ce));
		
		assertFalse(ce.equals(null));
		
		assertFalse(ce.equals(c1));

	}

	/**
	 * Test method for {@link es.uniovi.asw.model.ColegioElectoral#toString()}.
	 */
	@Test
	public final void testToString() {
		ce = new ColegioElectoral(nombre1, poblacion1, c1);
		assertEquals("ColegioElectoral [circunscripcion=Circunscripcion [id=null, "
				+ "comunidad=ComunidadAutonoma [id=null, nombre=ca1]], votos=[], votantes=[], nombre=n1, poblacion=p1]",
				ce.toString());
	}
	
	@Test
	public final void testSets() {
		ce = new ColegioElectoral(nombre1, poblacion1, c1);
		ce.setCircunscripcion(c2);
		ce.setNombre(nombre2);
		ce.setPoblacion(poblacion2);
		ce.setVotantes(null);
		ce.setVotos(null);
		assertTrue(ce.getCircunscripcion().equals(c2));
		assertTrue(ce.getNombre().equals(nombre2));
		assertTrue(ce.getPoblacion().equals(poblacion2));
		assertNull(ce.getVotantes());
		assertNull(ce.getVotos());

	}
	

}

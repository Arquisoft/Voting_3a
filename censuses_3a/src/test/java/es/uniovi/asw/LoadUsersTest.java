package es.uniovi.asw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.LoadFromExcel;
import es.uniovi.asw.parser.LoadFromTxt;

public class LoadUsersTest {

	
	/**
	 * Método que comprueba si es correcto el número de votantes cargados de la 
	 * hoja Excel
	 * 
	 * @throws IOException
	 */
	@Test
	public void testNumeroVotantesFichero() throws IOException {
		LoadFromExcel excel = new LoadFromExcel();
		List<Voter> voters = excel.loadUsers( "src/test/resources/test.xlsx" );
		//Comprobamos numero de votantes de la hoja Excel (son 4 filas (1 de cabecera y 3 de votantes))
		assertFalse(voters.size() == 4);
		
		//Comprobamos numero de votantes de la hoja Excel
		assertEquals(3, voters.size()); 
	}
	
	
	/**
	 * Método que comprueba que los votantes se cargan con los datos adecuados
	 * 
	 * @throws IOException
	 */
	@Test
	public void testDatosVotantesFichero() throws IOException{
		LoadFromExcel excel = new LoadFromExcel();
		List<Voter> voters = excel.loadUsers( "src/test/resources/test.xlsx" );
		Voter voter = voters.get(0); //Primer ciudadano
		assertEquals("Juan Torres Pardo", voter.getNombre());
		assertEquals("90500084Y", voter.getNif());
		assertEquals(234, voter.getPollingStationCode());
		assertEquals("jtp@hotmail.com", voter.getEmail());
		
		voter = voters.get(1); //Segundo ciudadano
		assertEquals("Luis López Fernando", voter.getNombre());
		assertEquals("19160962F", voter.getNif());
		assertEquals(345, voter.getPollingStationCode());
		assertEquals("llp@gmail.com", voter.getEmail());
		
		voter = voters.get(2); //Segundo ciudadano
		assertEquals("Ana Torres Pardo", voter.getNombre());
		assertEquals("09940449X", voter.getNif());
		assertEquals(456, voter.getPollingStationCode());
		assertEquals("atp@yahoo.com", voter.getEmail());
	}
	
	/**
	 * Método que comprueba si es correcto el número de votantes cargados de un 
	 * fichero txt
	 * 
	 * @throws IOException
	 */
	@Test
	public void testNumeroVotantesFicheroTxt() throws IOException {
		LoadFromTxt txt = new LoadFromTxt();
		List<Voter> voters = txt.loadUsers( "src/test/resources/test.txt" );
		//Comprobamos numero de votantes de la hoja Excel (son 4 filas (1 de cabecera y 4 de votantes))
		assertFalse(voters.size() == 5);
		
		//Comprobamos numero de votantes de la hoja Excel
		assertEquals(4, voters.size()); 
	}
	
	
	/**
	 * Método que comprueba que los votantes se cargan con los datos adecuados
	 * para la carga con ficheros de texto (txt)
	 * 
	 * @throws IOException
	 */
	@Test
	public void testDatosVotantesFicheroTxt() throws IOException{
		LoadFromTxt txt = new LoadFromTxt();
		List<Voter> voters = txt.loadUsers( "src/test/resources/test.txt" );
		Voter voter = voters.get(0); //Primer ciudadano
		assertEquals("Juan Torres Pardo", voter.getNombre());
		assertEquals("90500084Y", voter.getNif());
		assertEquals(234, voter.getPollingStationCode());
		assertEquals("jtp@hotmail.com", voter.getEmail());
		
		voter = voters.get(1); //Segundo ciudadano
		assertEquals(true, voter.getNombre()
				.contains("Luis"));
		assertEquals("19160962F", voter.getNif());
		assertEquals(345, voter.getPollingStationCode());
		assertEquals("llp@gmail.com", voter.getEmail());
		
		voter = voters.get(2); //Segundo ciudadano
		assertEquals("Ana Torres Pardo", voter.getNombre());
		assertEquals("09940449X", voter.getNif());
		assertEquals(456, voter.getPollingStationCode());
		assertEquals("atpyahoo.com", voter.getEmail());
	}
}

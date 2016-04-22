package es.uniovi.asw.steps;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.ComunidadAutonoma;

@IntegrationTest
@WebAppConfiguration
public class ConfigurarColegio {
  
  @Autowired
  protected WebApplicationContext context;

  protected MockMvc mvc;
  protected MvcResult result;
  
  @Value("${local.server.port}")
  protected int port;
  
  protected ColegioElectoral colegio;
  
  @Dado("^un colegio electoral de unas elecciones$")
  public void un_colegio_electoral_de_unas_elecciones() throws Throwable {
      colegio = new ColegioElectoral(null, null);
  }

  @Cuando("^le asignamos el nombre \"([^\"]*)\" de la circunscripción \"([^\"]*)\" y población \"([^\"]*)\"$")
  public void le_asignamos_el_nombre_de_la_circunscripción_y_población(String arg1, String arg2, String arg3) throws Throwable {
      colegio.setNombre(arg1);
      colegio.setPoblacion(arg3);
      colegio.setCircunscripcion(new Circunscripcion(arg2, new ComunidadAutonoma("Asturias")));
  }

  @Entonces("^comprobamos que los parámetros de \"([^\"]*)\" se han almacenado de forma correcta$")
  public void comprobamos_que_los_parámetros_de_se_han_almacenado_de_forma_correcta(String arg1) throws Throwable {
      assertEquals("Colegio 1", colegio.getNombre());
      assertEquals("Este", colegio.getCircunscripcion().getNombre());
      assertEquals("Oviedo", colegio.getPoblacion());
  }

  
  

}

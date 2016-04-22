package es.uniovi.asw.steps;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Eleccion;

@IntegrationTest
@WebAppConfiguration
public class AgregarElecciones {
  
  @Autowired
  protected WebApplicationContext context;

  protected MockMvc mvc;
  protected MvcResult result;
  
  @Value("${local.server.port}")
  protected int port;
  
  protected List<Eleccion> elecciones;
  protected Date date;

  
  @Dado("^una lista con las elecciones activas$")
  public void una_lista_con_las_elecciones_activas() throws Throwable {
      elecciones = new ArrayList<Eleccion>();
      elecciones.add(new Eleccion("Eleccion 1", new Date(), new Date(), new Time(System.currentTimeMillis()), new Time(System.currentTimeMillis())));
      elecciones.add(new Eleccion("Eleccion 2", new Date(), new Date(), new Time(System.currentTimeMillis()), new Time(System.currentTimeMillis())));
  }

  @Cuando("^creamos unas elecciones con un nombre \"([^\"]*)\",un numero de opciones de (\\d+) y una fecha de inicio de \"([^\"]*)\"$")
  public void creamos_unas_elecciones_con_un_nombre_un_numero_de_opciones_de_y_una_fecha_de_inicio_de(String arg1, int arg2, String arg3) throws Throwable {
      Eleccion e = new Eleccion();
      e.setNombre(arg1);
      e.setNumeroOpciones(arg2);
      DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
      date = format.parse(arg3);
      e.setFechaInicio(date);
      e.setFechaFin(date);
      for(int i = 0; i< arg2 ; i++){
    	  e.getOpciones().add(new Candidatura("Candidatura " + i ));
      }
      elecciones.add(e);
  }

  @Entonces("^comprobamos que para la fecha \"([^\"]*)\" existe una eleccion almacenada$")
  public void comprobamos_que_para_la_fecha_existe_una_eleccion_almacenada(String arg1) throws Throwable {
	  for(Eleccion e : elecciones){
		  if(e.getFechaInicio().equals(date)){
			  assertEquals(date, e.getFechaInicio());
		  }
	  }
  }

}

package es.uniovi.asw.steps;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class ConsultarCandidaturas {
	
	@Autowired
	protected WebApplicationContext context;

	protected MockMvc mvc;
	protected MvcResult result;

	@Value("${local.server.port}")
	protected int port;
	
	private List<Eleccion> elecciones;
	private Eleccion eleccion;

	@Dado("^una lista con las próximas elecciones activas$")
	public void una_lista_con_las_próximas_elecciones_activas() throws Throwable {
		 elecciones = new ArrayList<Eleccion>();
		    for(int i=0; i< 5; i++){
		    	elecciones.add(new Eleccion("Elecciones " + (i+1), new Date(), new Date(), new Time(System.currentTimeMillis()), new Time(System.currentTimeMillis())));
		    	for(int j=0; j<3; j++){
		    		elecciones.get(i).getOpciones().add(new Candidatura("Candidatura " + (j+1)));
		    	}
		    }
	}

	@Cuando("^el usuario selecciona las elecciones \"([^\"]*)\" con fecha (\\d+)/(\\d+)/(\\d+)$")
	public void el_usuario_selecciona_las_elecciones_con_fecha(String arg1, int arg2, int arg3, int arg4) throws Throwable {
		for(int i=0; i< 5; i++){
			if(elecciones.get(i).getNombre().equals("Elecciones 1")){
				this.eleccion = elecciones.get(i);
			}
		}
	}

	@Entonces("^al usuario se le muestran las opciones de voto que existen$")
	public void al_usuario_se_le_muestran_las_opciones_de_voto_que_existen() throws Throwable {
	    System.out.println("La lista de candidaturas son:");
	    System.out.println("Eleccion:  " + eleccion);
	    for(Candidatura c : eleccion.getOpciones()){
	    	System.out.println("\t-" + c);
	    }
	}

}

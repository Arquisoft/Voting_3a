package es.uniovi.asw.steps;

import java.util.ArrayList;
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
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.model.VotoConfirmado;

@IntegrationTest
@WebAppConfiguration
public class EmitirVoto {

	@Autowired
	protected WebApplicationContext context;

	protected MockMvc mvc;
	protected MvcResult result;

	@Value("${local.server.port}")
	protected int port;
	protected List<Eleccion> elecciones;
	protected Eleccion e;
	protected Candidatura candidatura;

	@Dado("^una lista con las elecciones que se encuentran activas$")
	public void una_lista_con_las_elecciones_que_se_encuentran_activas() throws Throwable {
	    elecciones = new ArrayList<Eleccion>();
	    for(int i=0; i< 5; i++){
	    	elecciones.add(new Eleccion("Eleccion " + (i+1)));
	    	for(int j=0; j<3; j++){
	    		elecciones.get(i).getOpciones().add(new Candidatura("Candidatura " + (j+1)));
	    	}
	    }
	    
	}

	@Cuando("^el usuario selecciona la elección \"([^\"]*)\"$")
	public void el_usuario_selecciona_la_elección(String arg1) throws Throwable {
		for(Eleccion ele : elecciones){
			if(ele.getNombre().equals(arg1)){
				e = ele;
			}
		}

	}

	@Entonces("^se le muestran las opciones de voto para esas elección$")
	public void se_le_muestran_las_opciones_de_voto_para_esas_elección() throws Throwable {
		for(Candidatura c : e.getOpciones()){
			System.out.println(c);
		}
	}

	@Cuando("^el usuario selecciona la opción \"([^\"]*)\" y selecciona guardar$")
	public void el_usuario_selecciona_la_opción_y_selecciona_guardar(String arg1) throws Throwable {
		for(Candidatura c : e.getOpciones()){
			if(c.getNombre().equals(arg1)){
				candidatura = c;
			}
		}
	}

	@Entonces("^se almacena el voto y se registra que votó$")
	public void se_almacena_el_voto_y_se_registra_que_votó() throws Throwable {
		System.out.println(e);
		Voter voter = new Voter("Paco", "info@paco.es", "ocap", "9449870L");
		VotoConfirmado confirmado = new VotoConfirmado(voter, e);
		confirmado.setHaVotado(true);
	}

}

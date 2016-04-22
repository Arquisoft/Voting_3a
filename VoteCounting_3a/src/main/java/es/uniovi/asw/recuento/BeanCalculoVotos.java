package es.uniovi.asw.recuento;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("BeanCalculo")
@Scope("session")
public class BeanCalculoVotos {
	
	private Map<String, Long> votos;
	private Map<String, Map<String, Long>> colegios;
	private Map<String, Map<String, Long>> comunidad;


	public String recuentoVotos (CountSystem e) {
		votos = e.getVotos();
		colegios = e.getColegios();
		comunidad = e.getComunidades();
		
		return "exito";
	}


	public Map<String, Long> getVotos() {
		return votos;
	}


	public Map<String, Map<String, Long>> getColegios() {
		return colegios;
	}


	public Map<String, Map<String, Long>> getComunidad() {
		return comunidad;
	}

}

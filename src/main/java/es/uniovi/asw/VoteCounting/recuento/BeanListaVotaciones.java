package es.uniovi.asw.recuento;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.Repository;

@Component("BeanListaVotaciones")
@Scope("session")
public class BeanListaVotaciones {
	
	public List<Eleccion> elecciones;

	@PostConstruct
	public void init() {
		
		this.elecciones = (List<Eleccion>) Repository.eleccionRep.findAll();
		
		System.out.println("BeanListaVotaciones creado");
	}

	public List<Eleccion> getElecciones() {
		return elecciones;
	}

	public void setElecciones(List<Eleccion> elecciones) {
		this.elecciones = elecciones;
	}
	

}

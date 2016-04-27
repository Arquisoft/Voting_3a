package es.uniovi.asw.VoteCounting.recuento;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbManagement.Persistence;
import es.uniovi.asw.model.Eleccion;

@Component("BeanListaVotaciones")
@Scope("session")
public class BeanListaVotaciones {
	
	public List<Eleccion> elecciones;

	@PostConstruct
	public void init() {
		
		this.elecciones = (List<Eleccion>) Persistence.voting.findAll();
		
		System.out.println("BeanListaVotaciones creado");
	}

	public List<Eleccion> getElecciones() {
		return elecciones;
	}

	public void setElecciones(List<Eleccion> elecciones) {
		this.elecciones = elecciones;
	}
	

}

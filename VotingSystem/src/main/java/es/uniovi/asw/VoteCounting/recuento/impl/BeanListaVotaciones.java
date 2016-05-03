package es.uniovi.asw.VoteCounting.recuento.impl;

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
		update();
		System.out.println("BeanListaVotaciones creado");
	}

	public void update() {
		this.elecciones = (List<Eleccion>) Persistence.voting.findAll();
	}

	public List<Eleccion> getElecciones() {
		return elecciones;
	}

	public void setElecciones(List<Eleccion> elecciones) {
		this.elecciones = elecciones;
	}

}

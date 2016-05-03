package es.uniovi.asw.VoteCounting.dto;

import es.uniovi.asw.model.Eleccion;

public class EleccionDto {
	
	private long id;
	private String nombre;

	public EleccionDto(long id, String nombre) {
		this.nombre = nombre;
	}
	
	public EleccionDto(Eleccion eleccion) {
		this.id = eleccion.getId();
		this.nombre = eleccion.getNombre();
	}

	public String getNombre() {
		return nombre;
	}

	public long getId() {
		return id;
	}

	
	
}

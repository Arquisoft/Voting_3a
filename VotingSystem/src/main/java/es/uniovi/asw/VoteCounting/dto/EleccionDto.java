package es.uniovi.asw.VoteCounting.dto;

import es.uniovi.asw.model.Eleccion;

public class EleccionDto {
	
	private String nombre;

	public EleccionDto(String nombre) {
		this.nombre = nombre;
	}
	
	public EleccionDto(Eleccion eleccion) {
		this.nombre = eleccion.getNombre();
	}

	public String getNombre() {
		return nombre;
	}

	
	
}

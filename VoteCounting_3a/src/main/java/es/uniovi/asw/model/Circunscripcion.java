package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Circunscripcion {
	
	@Id @GeneratedValue
	private Long id;
	 
	private String nombre;

	@ManyToOne
	private ComunidadAutonoma comunidad;
	
	@OneToMany(mappedBy = "circunscripcion")
	private Set<ColegioElectoral> colegios = new HashSet<>();
	
	Circunscripcion() {}
	
	public Circunscripcion(ComunidadAutonoma comunidad){
		Asociacion.ComunidadCircunscripcion.link(comunidad, this);
	}
	
	public Circunscripcion(String nombre, ComunidadAutonoma comunidad){
		this.nombre = nombre;
		Asociacion.ComunidadCircunscripcion.link(comunidad, this);
	}
	
	public ComunidadAutonoma getComunidad() {
		return comunidad;
	}

	public Set<ColegioElectoral> getColegios() {
		return colegios;
	}

	public void setColegios(Set<ColegioElectoral> colegios) {
		this.colegios = colegios;
	}

	public void setComunidad(ComunidadAutonoma comunidad) {
		this.comunidad = comunidad;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comunidad == null) ? 0 : comunidad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circunscripcion other = (Circunscripcion) obj;
		if (comunidad == null) {
			if (other.comunidad != null)
				return false;
		} else if (!comunidad.equals(other.comunidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Circunscripcion [id=" + id + ", comunidad=" + comunidad + "]";
	}

}

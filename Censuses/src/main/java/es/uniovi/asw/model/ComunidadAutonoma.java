package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ComunidadAutonoma {
	
	@Id @GeneratedValue
	private Long id;
	private String nombre;
	@OneToMany(mappedBy = "comunidad") 
	private Set<Circunscripcion> circunscripciones = new HashSet<>();
	
	ComunidadAutonoma() {}
	
	public ComunidadAutonoma(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Set<Circunscripcion> getCircunscripciones() {
		return circunscripciones;
	}

	public void setCircunscripciones(Set<Circunscripcion> circunscripciones) {
		this.circunscripciones = circunscripciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		ComunidadAutonoma other = (ComunidadAutonoma) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComunidadAutonoma [id=" + id + ", nombre=" + nombre + "]";
	}

}

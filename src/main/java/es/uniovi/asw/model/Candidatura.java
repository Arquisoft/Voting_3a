package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Candidatura {
	
	@Id @GeneratedValue
	private Long id;
	@ManyToOne
	private Eleccion eleccion;
	private String nombre;
	private String descripcion;
	private String programaElectoral;
	@OneToMany(mappedBy = "opcion")
	private Set<Voto> votos = new HashSet<>();
	
	public Long getId() {
		return id;
	}
	
	public Candidatura(String nombre,String descripcion,String programaElectoral, Eleccion e){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.programaElectoral = programaElectoral;
		Asociacion.EleccionOpcion.link(e, this);
	}

	public Candidatura() {}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Eleccion getEleccion() {
		return eleccion;
	}

	public void setEleccion(Eleccion eleccion) {
		this.eleccion = eleccion;
	}

	public Set<Voto> getVotos() {
		return votos;
	}

	public void setVotos(Set<Voto> votos) {
		this.votos = votos;
	}

	public String getProgramaElectoral() {
		return programaElectoral;
	}

	public void setProgramaElectoral(String programaElectoral) {
		this.programaElectoral = programaElectoral;
	}

	@Override
	public String toString() {
		return "Candidatura [id=" + id + ", eleccion=" + eleccion + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", programaElectoral=" + programaElectoral + ", votos=" + votos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eleccion == null) ? 0 : eleccion.hashCode());
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
		Candidatura other = (Candidatura) obj;
		if (eleccion == null) {
			if (other.eleccion != null)
				return false;
		} else if (!eleccion.equals(other.eleccion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}

package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ColegioElectoral {
	
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private Circunscripcion circunscripcion;
	
	@OneToMany(mappedBy = "colegio")
	private Set<Voto> votos = new HashSet<>();
	
	@OneToMany(mappedBy = "colegio")
	private Set<Voter> votantes = new HashSet<>();
	
	private String nombre;
	private String poblacion;
	
	ColegioElectoral() {}
	
	public ColegioElectoral(String nombre, String poblacion, Circunscripcion c){
		this.nombre = nombre;
		this.poblacion = poblacion;
		Asociacion.CircunscripcionColegio.link(c, this);
	}
	
	public Set<Voto> getVotos() {
		return votos;
	}
	
	public void setVotos(Set<Voto> votos) {
		this.votos = votos;
	}
	
	public Set<Voter> getVotantes() {
		return votantes;
	}
	
	public void setVotantes(Set<Voter> votantes) {
		this.votantes = votantes;
	}
	
	public String getPoblacion() {
		return poblacion;
	}
	
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	public Circunscripcion getCircunscripcion() {
		return circunscripcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setCircunscripcion(Circunscripcion circunscripcion) {
		this.circunscripcion = circunscripcion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ColegioElectoral other = (ColegioElectoral) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ColegioElectoral [circunscripcion=" + circunscripcion + ", votos=" + votos + ", votantes=" + votantes
				+ ", nombre=" + nombre + ", poblacion=" + poblacion + "]";
	}
	
	

}

package es.uniovi.asw.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Eleccion {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@NotEmpty
	private String nombre;

	private Date fechaInicio;
	private Date fechaFin;
	private Integer numeroOpciones;
	private boolean activa;

	@OneToMany(mappedBy = "eleccion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Candidatura> opciones = new ArrayList<Candidatura>();

	@OneToMany(mappedBy = "eleccion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<VotoConfirmado> votantes = new HashSet<VotoConfirmado>();

	public Eleccion(String nombre, Date inicio, Date fin) {
		this.nombre = nombre;
		this.fechaInicio = inicio;
		this.fechaFin = fin;
	}

	public Eleccion(String nombre) {
		this.nombre = nombre;
	}

	public Eleccion() {
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Candidatura> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Candidatura> opciones) {
		this.opciones = opciones;
	}

	public Set<VotoConfirmado> getVotantes() {
		return votantes;
	}

	public void setVotantes(Set<VotoConfirmado> votantes) {
		this.votantes = votantes;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Eleccion [id=" + id + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", opciones=" + opciones + "]";
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
		Eleccion other = (Eleccion) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public Integer getNumeroOpciones() {
		return numeroOpciones;
	}

	public void setNumeroOpciones(Integer numeroOpciones) {
		this.numeroOpciones = numeroOpciones;
	}

}

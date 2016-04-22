package es.uniovi.asw.model;

import java.sql.Time;
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
	
	@Id @GeneratedValue
	private Long id;
	@NotNull @NotEmpty
	private String nombre;
	@NotNull
	private Date fechaInicio;
	@NotNull
	private Date fechaFin;
	private Time horaInicio, horaFin;
	private Integer numeroOpciones;
	private boolean activa;

	@OneToMany(mappedBy = "eleccion", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Candidatura> opciones = new ArrayList<Candidatura>();
	
	@OneToMany(mappedBy = "eleccion")
	//private Set<VotoConfirmado> votantes;
	private Set<VotoConfirmado> votantes = new HashSet<VotoConfirmado>();
	
	public Eleccion(String nombre, Date inicio, Date fin, Time hInicio, Time hFin){
		this.nombre = nombre;
		this.fechaInicio = inicio;
		this.fechaFin = fin;
		this.horaInicio = hInicio;
		this.horaFin = hFin;
	}
	
	public Eleccion(String nombre){
		this.nombre = nombre;
	}
	
	public Eleccion() {}
	
	public String getNombre() {
		return nombre;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.horaInicio = new Time(fechaInicio.getTime());
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.horaFin = new Time(fechaFin.getTime());
		this.fechaFin = fechaFin;
	}
	
	public Time getHoraInicio() {
		return horaInicio;
	}
	
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	public Time getHoraFin() {
		return horaFin;
	}
	
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
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
	
	public Integer getNumeroOpciones() {
		return numeroOpciones;
	}

	public void setNumeroOpciones(Integer numeroOpciones) {
		this.numeroOpciones = numeroOpciones;
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
				+ ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", opciones=" + opciones + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
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
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}

package es.uniovi.asw.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Voter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nombre;
	@NotNull
	private String email;
	@NotNull
	private String nif;
	@NotNull
	private String password;
	@ManyToOne
	private ColegioElectoral colegio;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "votante", cascade = CascadeType.ALL)
	private Set<VotoConfirmado> elecciones = new HashSet<>();

	public Voter() {
	}

	/*
	 * public Voter(ColegioElectoral colegio) {
	 * 
	 * }
	 */

	public Voter(String nombre, String email, String password, String nif) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.nif = nif;
	}

	public Voter(String nombre, String email, String password, String nif, ColegioElectoral pollingStation) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.nif = nif;
		Asociacion.ColegioVotante.link(pollingStation, this);
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public ColegioElectoral getColegio() {
		return colegio;
	}

	public void setColegio(ColegioElectoral colegio) {
		this.colegio = colegio;
	}

	public Set<VotoConfirmado> getElecciones() {
		return elecciones;
	}

	public void setElecciones(Set<VotoConfirmado> elecciones) {
		this.elecciones = elecciones;
	}

	@Override
	public String toString() {
		return "Voter [nombre=" + nombre + ", email=" + email + ", nif=" + nif + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
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
		Voter other = (Voter) obj;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	}

}

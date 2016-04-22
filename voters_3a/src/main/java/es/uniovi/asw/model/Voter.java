package es.uniovi.asw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Dario Rodríguez García (@dariorg on GitHub)
 * @author David González García (@davidglezz on GitHub)
 * 
 * @version 2016.02.20
 *
 *          Entidad del modelo de dominio que recoge los datos de los ciudadanos
 *          censados así como el colegio electoral/mesa en el que emitir su
 *          voto.
 * 
 */

@Entity
@Table(name = "VOTER")
public class Voter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nombre;

	@NotNull
	@Column(nullable = false, unique = true)
	private String email;

	@NotNull
	private String nif;

	@NotNull
	private String password;

	@NotNull
	private Long pollingStationCode;

	public Voter() {}

	public Voter(String nombre, String email, String password, String nif, long pollingStationCode) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.nif = nif;
		this.pollingStationCode = pollingStationCode;
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

	public Long getPollingStationCode() {
		return pollingStationCode;
	}

	public void setPollingStationCode(long pollingStationCode) {
		this.pollingStationCode = pollingStationCode;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Voter [nombre=" + nombre + ", email=" + email + ", nif=" + nif + ", password=" + password
				+ ", pollingStationCode=" + pollingStationCode + "]";
	}

}

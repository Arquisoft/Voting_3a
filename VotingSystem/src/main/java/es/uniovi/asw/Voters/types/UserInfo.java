package es.uniovi.asw.voters.types;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.uniovi.asw.model.Voter;

@XmlRootElement(name = "UserInfo")
public class UserInfo {
	private static final Logger log = LoggerFactory.getLogger(UserInfo.class);

	private String name;
	private String nif;
	private String email;
	private String pollingStation;

	public UserInfo() {
	}

	public UserInfo(String name, String nif, String email, String pollingStation) {
		this.name = name;
		this.nif = nif;
		this.email = email;
		this.pollingStation = pollingStation;
		log.info(this.toString());
	}

	public UserInfo(Voter voter) {
		this.name = voter.getNombre();
		this.nif = voter.getNif();
		this.email = voter.getEmail();
		this.pollingStation = voter.getColegio().getNombre() + " en " + voter.getColegio().getPoblacion();
	}

	@XmlElement
	public String getName() {
		return name;
	}

	@XmlElement
	public String getNif() {
		return nif;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	@XmlElement
	public String getPollingStationCode() {
		return pollingStation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
		result = prime * result + ((pollingStation == null) ? 0 : pollingStation.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		if (pollingStation == null) {
			if (other.pollingStation != null)
				return false;
		} else if (!pollingStation.equals(other.pollingStation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", nif=" + nif + ", email=" + email + ", pollingStationCode=" + pollingStation
				+ "]";
	}

}
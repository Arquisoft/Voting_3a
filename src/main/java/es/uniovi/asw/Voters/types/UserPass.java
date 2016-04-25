package es.uniovi.asw.types;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserPass")
public class UserPass {
	private String login;
	private String password;

	public UserPass() {
	}

	public UserPass(String login, String password) {
		this.login = login;
		this.password = Encrypter.encrypt(password);
	}

	@XmlElement
	public String getLogin() {
		return login;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "UserPass [login=" + login + ", password=" + password + "]";
	}

}

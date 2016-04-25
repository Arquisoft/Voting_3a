package es.uniovi.asw.types;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserPass")
public class ChangePass {
	private String login;
	private String oldPassword;
	private String newPassword;

	public ChangePass() {
	}

	public ChangePass(String login, String oldPassword, String newPassword) {
		this.login = login;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	@XmlElement
	public String getLogin() {
		return login;
	}

	@XmlElement
	public String getOldPassword() {
		return oldPassword;
	}

	@XmlElement
	public String getNewPassword() {
		return newPassword;
	}

}

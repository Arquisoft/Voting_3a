package es.uniovi.asw.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.uniovi.asw.types.UserPass;

// No usado actualmente
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(UserPass userPass) {
		super("Usuario '" + userPass.getLogin() + "' no encontrado.");
	}
}
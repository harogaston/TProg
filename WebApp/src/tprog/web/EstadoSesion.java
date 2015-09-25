package tprog.web;

public enum EstadoSesion {

	NO_LOGIN, // no hay sesión iniciada
	LOGIN_CORRECTO, // tiene la sesión iniciada
	LOGIN_INCORRECTO    // le erro a la sesión al menos una vez
}

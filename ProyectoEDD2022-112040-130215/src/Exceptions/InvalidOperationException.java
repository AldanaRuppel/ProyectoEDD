package Exceptions;

/**
 * Clase InvalidOperationException.
 * Modela una excepcion para operacion invalida.
 * @author Comision número 38. Ruppel Aldana /  Pires Valentin
 */
public class InvalidOperationException extends Exception{
	
	/**
	 * Crea una InvalidOperationException.
	 * @param msj, mensage que se lanza cuando se captura la excepcion.
	 */
	public InvalidOperationException(String msj) {
		super(msj);
	}
}
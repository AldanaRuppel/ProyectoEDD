package Exceptions;

/**
 * Clase InvalidKeyException.
 * Modela una excepcion para clave invalida.
 * @author Comision número 38. Ruppel Aldana/ Pires Valentin
 */
public class InvalidKeyException extends Exception{
	
	/**
	 * Crea una InvalidKeyException.
	 * @param msj, mensage que se lanza cuando se captura la excepcion.
	 */
	public InvalidKeyException(String msj) {
		super(msj);
	}
}
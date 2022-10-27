package Exceptions;

/**
 * Clase InvalidEntryException.
 * Modela una excepcion para entrada invalida.
 * @author Comision número 38. Ruppel Aldana/ Pires Valentin
 */
public class InvalidEntryException extends Exception{
	
	/**
	 * Crea una InvalidEntryException.
	 * @param msj, mensage que se lanza cuando se captura la excepcion.
	 */
	public InvalidEntryException(String msj) {
		super(msj);
	}
}
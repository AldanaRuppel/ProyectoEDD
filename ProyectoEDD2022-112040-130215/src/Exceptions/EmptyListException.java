package Exceptions;

/**
 * Clase EmptyListException.
 * Modela una excepcion para lista vacia.
 * @author Comision número 38. Ruppel Aldana /Pires Valentin
 */
public class EmptyListException extends Exception{
	
	/**
	 * Crea una EmptyListException.
	 * @param msj, mensage que se lanza cuando se captura la excepcion.
	 */
	public 	EmptyListException(String msj) {
		super(msj);
	}
}
